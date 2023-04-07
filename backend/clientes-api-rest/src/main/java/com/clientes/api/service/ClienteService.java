package com.clientes.api.service;

import com.clientes.api.domain.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    Cliente saveOrUpdate(Cliente cliente);

    boolean delete(Long id);

}
