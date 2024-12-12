package com.joao.cadastro.controllers;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import com.joao.cadastro.core.usecases.ReadUseCase;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.infra.RestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    @Autowired
    CriarRegistroAlunoUseCase criarRegistroAlunoUseCase;

    @Autowired
    ReadUseCase readUseCase;

    @Autowired
    DeleteUseCase deleteUseCase;

    @Autowired
    UpdateUseCase updateUseCase;

    @PostMapping(value = "create")
    public ResponseEntity<RestMessage> postRequestResgistroAluno(@RequestBody AlunoDto alunoDto){
        return criarRegistroAlunoUseCase.criarRegistroAluno(alunoDto);
    }

    @GetMapping(value = "read")
    public AlunoDto readRequest(@RequestBody AlunoDto alunoDto){
        return readUseCase.buscaInfoAluno(alunoDto.getNumeroDocumentoMatricula());
    }

    @DeleteMapping(value = "delete")
    public String deleteRequest(@RequestBody AlunoDto alunoDto){
        return deleteUseCase.deletarAluno(alunoDto);
    }

    @PatchMapping(value = "update")
    public String requestUpdate(@RequestBody AlunoDto alunoDto){
        return updateUseCase.atualizarRegistroAluno(alunoDto);
    }
}
