package com.example.prova.controller;

import com.example.prova.dto.TarefasDto;
import com.example.prova.dto.TarefasForm;
import com.example.prova.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping
    public ResponseEntity<List<TarefasDto>> listAll(){
    return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<TarefasDto> save(@RequestBody @Validated TarefasForm tarefasForm){
        return ResponseEntity.ok(service.save(tarefasForm));
    }
}
