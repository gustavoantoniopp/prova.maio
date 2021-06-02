package com.example.prova.model;

import com.example.prova.dto.TarefasForm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tarefas")
public class Tarefas {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String tarefa;

    public Tarefas(){

    }

    public Tarefas(Long id, String tarefa) {
        this.id = id;
        this.tarefa = tarefa;
    }
    public static Tarefas from (TarefasForm tarefasForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(tarefasForm, Tarefas.class);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefas tarefas = (Tarefas) o;
        return id.equals(tarefas.id) && tarefa.equals(tarefas.tarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefa);
    }
}
