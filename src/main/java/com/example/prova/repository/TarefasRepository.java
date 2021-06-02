package com.example.prova.repository;

import com.example.prova.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
    Optional<Tarefas> findByTarefaContaining(String tarefa);

}
