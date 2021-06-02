package com.example.prova.controller;

import com.example.prova.dto.ClienteDto;
import com.example.prova.dto.ClienteForm;
import com.example.prova.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody @Validated ClienteForm clienteForm){
        return ResponseEntity.ok(service.save(clienteForm));
    }
}
