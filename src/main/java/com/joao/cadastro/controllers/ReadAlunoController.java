package com.joao.cadastro.controllers;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import com.joao.cadastro.core.usecases.ReadUseCase;
import lombok.Locked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ReadAlunoController{
    @Autowired
    ReadUseCase readUseCase;

    //@PostMapping(value = "deletar")
   /* @GetMapping(value = "ler")
    public void readRequest(@RequestBody UUID id_aluno){
        System.out.println(id_aluno);
        //return readUseCase.buscaInfoAluno(id_aluno);
    }*/

    @GetMapping(value = "ler")
    public AlunoDto readRequest(@RequestBody AlunoDto alunoDto){
        //System.out.println(alunoDto.getId_aluno());
        return readUseCase.buscaInfoAluno(alunoDto.getId_aluno());
    }
}
