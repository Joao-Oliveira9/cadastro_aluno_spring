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

    @GetMapping(value = "read")
    public AlunoDto readRequest(@RequestBody AlunoDto alunoDto){
        return readUseCase.buscaInfoAluno(alunoDto.getNumeroDocumentoMatricula());
    }
}
