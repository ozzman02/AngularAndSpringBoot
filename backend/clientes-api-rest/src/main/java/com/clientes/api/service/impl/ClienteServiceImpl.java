package com.clientes.api.service.impl;

import com.clientes.api.domain.Cliente;
import com.clientes.api.exeception.CustomNotFoundException;
import com.clientes.api.repository.ClienteRepository;
import com.clientes.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static com.clientes.api.exeception.CustomExceptionMapper.APPLICATION_EXCEPTIONS;
import static com.clientes.api.exeception.ExceptionConstants.CLIENT_NOT_FOUND_EXCEPTION;

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
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) { return clienteRepository.findAll(pageable); }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id)  {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException(buildCustomerNotFoundErrorMessage(id)));
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
                clienteRepository.save(clienteActual);
                return clienteActual;
            }).orElseThrow(() -> new CustomNotFoundException(buildCustomerNotFoundErrorMessage(cliente.getId())));
        }
        return clienteActualizado;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        clienteRepository.findById(id).map(clienteActual -> {
            clienteRepository.deleteById(clienteActual.getId());
            return clienteActual;
        }).orElseThrow(() -> new CustomNotFoundException(buildCustomerNotFoundErrorMessage(id)));
        return true;
    }

    private String buildCustomerNotFoundErrorMessage(Long id) {
        return APPLICATION_EXCEPTIONS.get(CLIENT_NOT_FOUND_EXCEPTION)
                .replace("${first}", String.valueOf(id));
    }

}
