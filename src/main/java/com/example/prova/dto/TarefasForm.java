package com.example.prova.dto;

import com.example.prova.model.Tarefas;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class TarefasForm {

    @NotNull
    private String tarefa;

    public static TarefasForm from (Tarefas tarefas){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(tarefas, TarefasForm.class);

    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
