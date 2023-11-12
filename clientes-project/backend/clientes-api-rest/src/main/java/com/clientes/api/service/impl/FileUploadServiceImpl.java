package com.clientes.api.service.impl;

import com.clientes.api.domain.Cliente;
import com.clientes.api.exeception.ApplicationException;
import com.clientes.api.repository.ClienteRepository;
import com.clientes.api.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.clientes.api.constants.ApplicationConstants.*;
import static com.clientes.api.util.ApplicationUtil.buildErrorMessage;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final ClienteRepository clienteRepository;

    private final Logger log = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Autowired
    public FileUploadServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
        Resource resource = getResourceFromFilePath(filePath);
        if (!resource.exists() && !resource.isReadable()) {
            filePath = IMAGES_DIRECTORY.resolve(NO_USER_ICON_IMAGE_NAME).toAbsolutePath();
            resource = getResourceFromFilePath(filePath);
            log.error("Error no se pudo cargar la imagen: " + nombreFoto);
        }
        return resource;
    }

    @Override
    public HttpHeaders createContentDispositionHeaders(Resource resource) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
        return headers;
    }

    @Override
    public void deleteExistingProfilePhoto(Cliente cliente) {
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

    private Resource getResourceFromFilePath(Path filePath) {
        try {
            return new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new ApplicationException(MALFORMED_URL_EXCEPTION, MALFORMED_URL_EXCEPTION_ERROR_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
