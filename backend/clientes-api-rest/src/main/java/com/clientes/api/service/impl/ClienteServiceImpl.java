package com.clientes.api.service.impl;

import com.clientes.api.domain.Cliente;
import com.clientes.api.exeception.ApplicationException;
import com.clientes.api.repository.ClienteRepository;
import com.clientes.api.service.ClienteService;
import com.clientes.api.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.clientes.api.constants.ApplicationConstants.CLIENT_NOT_FOUND_ERROR_MESSAGE;
import static com.clientes.api.constants.ApplicationConstants.CLIENT_NOT_FOUND_EXCEPTION;
import static com.clientes.api.util.ApplicationUtil.buildErrorMessage;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final FileUploadService fileUploadService;

    private final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, FileUploadService fileUploadService) {
        this.clienteRepository = clienteRepository;
        this.fileUploadService = fileUploadService;
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
            fileUploadService.deleteExistingProfilePhoto(clienteActual);
            clienteRepository.deleteById(clienteActual.getId());
            return clienteActual;
        }).orElseThrow(() -> new ApplicationException(CLIENT_NOT_FOUND_EXCEPTION,
                buildErrorMessage(CLIENT_NOT_FOUND_ERROR_MESSAGE, String.valueOf(id)),
                HttpStatus.NOT_FOUND)
        );
        return true;
    }

}
