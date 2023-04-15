package com.clientes.api.controller;

import com.clientes.api.domain.Cliente;
import com.clientes.api.service.ClienteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    private final ClienteService clienteService;

    private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

    @Autowired
    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page) {
        return clienteService.findAll(PageRequest.of(page, 4));
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
    }

    @PutMapping("/clientes")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.saveOrUpdate(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/clientes/upload")
    public ResponseEntity<?> uploadProfilePhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        return new ResponseEntity<>(clienteService.uploadPicture(file, id), HttpStatus.CREATED);
    }

    @GetMapping("/clientes/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> downloadProfilePhoto(@PathVariable String nombreFoto) {
        Resource resource = clienteService.downloadProfilePhoto(nombreFoto);
        HttpHeaders headers = clienteService.createContentDispositionHeaders(resource);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
