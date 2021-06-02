package com.example.prova.service;

import com.example.prova.dto.TarefasDto;
import com.example.prova.dto.TarefasForm;
import com.example.prova.model.Tarefas;
import com.example.prova.repository.TarefasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefasService {
    private final Logger logger = LoggerFactory.getLogger(TarefasService.class);

    private final TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository){this.tarefasRepository = tarefasRepository;}

    public List<TarefasDto> findAll(){
        List<Tarefas> list = tarefasRepository.findAll();
        return list.stream().map(TarefasDto::from).collect(Collectors.toList());
    }

    public TarefasDto save(TarefasForm tarefasForm){
        if (tarefasRepository.findByTarefaContaining(tarefasForm.getTarefa()).isPresent()){
            logger.error("Tarefa já existe {}", tarefasForm.getTarefa());
        }
        Tarefas tarefas = Tarefas.from(tarefasForm);
        return TarefasDto.from(tarefasRepository.save(tarefas));
    }

}
