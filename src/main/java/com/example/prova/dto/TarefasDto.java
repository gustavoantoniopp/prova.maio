package com.example.prova.dto;

import com.example.prova.model.Tarefas;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class TarefasDto {
    private Long id;
    private String tarefa;

    public static TarefasDto from (Tarefas tarefas){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(tarefas, TarefasDto.class);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}

