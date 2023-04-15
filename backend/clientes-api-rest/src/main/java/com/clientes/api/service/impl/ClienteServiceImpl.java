package com.clientes.api.service.impl;

import com.clientes.api.domain.Cliente;
import com.clientes.api.exeception.ApplicationException;
import com.clientes.api.repository.ClienteRepository;
import com.clientes.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.clientes.api.constants.ApplicationConstants.*;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) { return clienteRepository.findAll(pageable); }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id)  {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND_EXCEPTION,
                        buildErrorMessage(CLIENT_NOT_FOUND_ERROR_MESSAGE, String.valueOf(id)),
                        HttpStatus.NOT_FOUND)
                );
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente saveOrUpdate(Cliente cliente) {
        Cliente clienteActualizado;
        if (cliente.getId() == null) {
            return clienteRepository.save(cliente);
        } else {
            clienteActualizado = clienteRepository.findById(cliente.getId()).map(clienteActual -> {
                clienteActual.setNombre(cliente.getNombre());
                clienteActual.setApellido(cliente.getApellido());
                clienteActual.setEmail(cliente.getEmail());
                clienteActual.setCreateAt(cliente.getCreateAt());
                clienteRepository.save(clienteActual);
                return clienteActual;
            }).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND_EXCEPTION,
                    buildErrorMessage(CLIENT_NOT_FOUND_ERROR_MESSAGE, String.valueOf(cliente.getId())),
                    HttpStatus.NOT_FOUND)
            );
        }
        return clienteActualizado;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        clienteRepository.findById(id).map(clienteActual -> {
            deleteExistingProfilePhoto(clienteActual);
            clienteRepository.deleteById(clienteActual.getId());
            return clienteActual;
        }).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND_EXCEPTION,
                buildErrorMessage(CLIENT_NOT_FOUND_ERROR_MESSAGE, String.valueOf(id)),
                HttpStatus.NOT_FOUND)
        );
        return true;
    }

    @Override
    public Map<String, Object> uploadPicture(MultipartFile file, Long id) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND_EXCEPTION,
                        buildErrorMessage(CLIENT_NOT_FOUND_ERROR_MESSAGE, String.valueOf(id)),
                        HttpStatus.NOT_FOUND)
                );
        if (!file.isEmpty() && file.getOriginalFilename() != null) {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename().trim();
            Path filePath = UPLOADS_DIRECTORY.resolve(fileName).toAbsolutePath();
            try {
                Files.copy(file.getInputStream(), filePath);
            } catch (IOException e) {
                throw new ApplicationException(FILE_UPLOAD_EXCEPTION,
                        buildErrorMessage(FILE_UPLOAD_EXCEPTION_ERROR_MESSAGE, fileName),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
            deleteExistingProfilePhoto(cliente);
            cliente.setFoto(fileName);
            clienteRepository.save(cliente);
            response.put("cliente", cliente);
            response.put("mensaje", "La imagen se ha subido correctamente " + fileName);
        } else {
            throw new ApplicationException(EMPTY_PROFILE_PHOTO_EXCEPTION,
                    EMPTY_PROFILE_PHOTO_EXCEPTION_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public Resource downloadProfilePhoto(String nombreFoto) {
        Path filePath = UPLOADS_DIRECTORY.resolve(nombreFoto).toAbsolutePath();
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new ApplicationException(MALFORMED_URL_EXCEPTION, MALFORMED_URL_EXCEPTION_ERROR_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (!resource.exists() && !resource.isReadable()) {
            throw new ApplicationException(PROFILE_PHOTO_NOT_READABLE_EXCEPTION,
                    buildErrorMessage(PROFILE_PHOTO_NOT_READABLE_EXCEPTION_ERROR_MESSAGE, nombreFoto),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resource;
    }

    @Override
    public HttpHeaders createContentDispositionHeaders(Resource resource) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
        return headers;
    }

    private void deleteExistingProfilePhoto(Cliente cliente) {
        String nombreFotoAnterior = cliente.getFoto();
        if (nombreFotoAnterior != null && !nombreFotoAnterior.isBlank()) {
            Path rutaFotoAnterior = UPLOADS_DIRECTORY.resolve(nombreFotoAnterior).toAbsolutePath();
            File archivoFotoAnterior = rutaFotoAnterior.toFile();
            if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                archivoFotoAnterior.delete();
            } else {
                throw new ApplicationException(DELETE_PROFILE_PHOTO_EXCEPTION,
                        buildErrorMessage(DELETE_PROFILE_PHOTO_EXCEPTION_ERROR_MESSAGE, nombreFotoAnterior),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
    }

    private String buildErrorMessage(String errorMessage, String argument) {
        return errorMessage.replace("${first}", argument);
    }

}
