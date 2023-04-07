package com.clientes.api.service.impl;

import com.clientes.api.domain.Cliente;
import com.clientes.api.repository.ClienteRepository;
import com.clientes.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente saveOrUpdate(Cliente cliente) {
        if (cliente.getId() == null) {
            return clienteRepository.save(cliente);
        } else {
            Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
            if (clienteOptional.isPresent()) {
                Cliente clienteActual = clienteOptional.get();
                clienteActual.setNombre(cliente.getNombre());
                clienteActual.setApellido(cliente.getApellido());
                clienteActual.setEmail(cliente.getEmail());
                clienteRepository.save(clienteActual);
                return clienteActual;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
