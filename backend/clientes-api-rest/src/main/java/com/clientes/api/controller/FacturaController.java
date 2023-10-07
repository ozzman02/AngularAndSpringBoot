package com.clientes.api.controller;

import com.clientes.api.domain.Factura;
import com.clientes.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.clientes.api.constants.ApplicationConstants.ANGULAR_APP_ORIGIN_URL;
import static com.clientes.api.constants.ApplicationConstants.BASE_MAPPING;

@CrossOrigin(origins = {ANGULAR_APP_ORIGIN_URL})
@RequestMapping(BASE_MAPPING)
@RestController
public class FacturaController {

    private final ClienteService clienteService;

    @Autowired
    public FacturaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { clienteService.deleteFacturaById(id); }

}
