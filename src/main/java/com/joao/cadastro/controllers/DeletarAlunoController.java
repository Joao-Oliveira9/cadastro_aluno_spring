package com.joao.cadastro.controllers;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletarAlunoController {

    @Autowired
    DeleteUseCase deleteUseCase;

    @DeleteMapping(value = "delete")
    public String deleteRequest(@RequestBody AlunoDto alunoDto){
        return deleteUseCase.deletarAluno(alunoDto);
    }
}
