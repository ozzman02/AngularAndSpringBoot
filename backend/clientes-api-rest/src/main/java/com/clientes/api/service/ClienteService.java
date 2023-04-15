package com.clientes.api.service;

import com.clientes.api.domain.Cliente;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

public interface ClienteService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    Cliente saveOrUpdate(Cliente cliente);

    boolean delete(Long id);

    Map<String, Object> uploadPicture(MultipartFile file, Long id);

    Resource downloadProfilePhoto(String nombreFoto);

    HttpHeaders createContentDispositionHeaders(Resource resource);

}
