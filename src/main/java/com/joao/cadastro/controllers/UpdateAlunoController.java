package com.joao.cadastro.controllers;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateAlunoController {
    @Autowired
    UpdateUseCase updateUseCase;

    @PatchMapping(value = "update")
    public String requestUpdate(@RequestBody AlunoDto alunoDto){
       return updateUseCase.atualizarRegistroAluno(alunoDto);
    }
}
