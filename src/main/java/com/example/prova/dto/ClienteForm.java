package com.example.prova.dto;

import com.example.prova.model.Cliente;
import com.example.prova.model.Tarefas;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ClienteForm {

    @NotNull
    private String nome;
    private Tarefas tarefas;


    public static ClienteForm from (Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(cliente, ClienteForm.class);

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
