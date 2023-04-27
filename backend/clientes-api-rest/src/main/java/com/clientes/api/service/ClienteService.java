package com.clientes.api.service;

import com.clientes.api.domain.Cliente;
import com.clientes.api.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    Cliente saveOrUpdate(Cliente cliente);

    boolean delete(Long id);

    List<Region> findAllRegions();

}
