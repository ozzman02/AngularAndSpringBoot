package com.clientes.api.service;

import com.clientes.api.domain.Cliente;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUploadService {

    Map<String, Object> uploadPicture(MultipartFile file, Long id);

    Resource downloadProfilePhoto(String nombreFoto);

    HttpHeaders createContentDispositionHeaders(Resource resource);

    void deleteExistingProfilePhoto(Cliente cliente);

}
