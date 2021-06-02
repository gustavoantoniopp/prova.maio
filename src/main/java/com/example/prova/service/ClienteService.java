package com.example.prova.service;

import com.example.prova.dto.ClienteDto;
import com.example.prova.dto.ClienteForm;
import com.example.prova.model.Cliente;
import com.example.prova.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){this.clienteRepository = clienteRepository;}

    public List<ClienteDto> findAll(){
        List<Cliente> list = clienteRepository.findAll();
        return list.stream().map(ClienteDto::from).collect(Collectors.toList());
    }

    public ClienteDto save(ClienteForm clienteForm){
        if (clienteRepository.findByNomeContaining(clienteForm.getNome()).isPresent()){
            logger.error("Cliente já existe {}", clienteForm.getNome());
        }
        Cliente cliente = Cliente.from(clienteForm);
        return ClienteDto.from(clienteRepository.save(cliente));
    }

}
