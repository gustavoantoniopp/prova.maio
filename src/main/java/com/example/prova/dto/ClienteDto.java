package com.example.prova.dto;

import com.example.prova.model.Cliente;
import com.example.prova.model.Tarefas;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ClienteDto {
    private Long id;
    private String nome;
    private Tarefas tarefas;

    public static ClienteDto from (Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(cliente, ClienteDto.class);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tarefas getTarefas() {
        return tarefas;
    }

    public void setTarefas(Tarefas tarefas) {
        this.tarefas = tarefas;
    }
}
