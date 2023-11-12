package com.clientes.api.controller;

import com.clientes.api.domain.Cliente;
import com.clientes.api.domain.Region;
import com.clientes.api.service.ClienteService;
import com.clientes.api.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static com.clientes.api.constants.ApplicationConstants.*;

@CrossOrigin(origins = {ANGULAR_APP_ORIGIN_URL, ALL_ORIGINS})
@RestController
@RequestMapping(BASE_MAPPING)
public class ClienteRestController {

    private final ClienteService clienteService;

    private final FileUploadService fileUploadService;

    private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

    @Autowired
    public ClienteRestController(ClienteService clienteService, FileUploadService fileUploadService) {
        this.clienteService = clienteService;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page) {
        return clienteService.findAll(PageRequest.of(page, PAGE_SIZE));
    }

    @Secured({ROLE_USER, ROLE_ADMIN})
    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @Secured(ROLE_ADMIN)
    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
    }

    @Secured(ROLE_ADMIN)
    @PutMapping("/clientes")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.saveOrUpdate(cliente), HttpStatus.CREATED);
    }

    @Secured(ROLE_ADMIN)
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
    }

    @Secured({ROLE_USER, ROLE_ADMIN})
    @PostMapping("/clientes/upload")
    public ResponseEntity<?> uploadProfilePhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        return new ResponseEntity<>(fileUploadService.uploadPicture(file, id), HttpStatus.CREATED);
    }

    @GetMapping("/clientes/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> downloadProfilePhoto(@PathVariable String nombreFoto) {
        Resource resource = fileUploadService.downloadProfilePhoto(nombreFoto);
        HttpHeaders headers = fileUploadService.createContentDispositionHeaders(resource);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @Secured(ROLE_ADMIN)
    @GetMapping("/clientes/regiones")
    public List<Region> listarRegiones() {
        return clienteService.findAllRegions();
    }

}
