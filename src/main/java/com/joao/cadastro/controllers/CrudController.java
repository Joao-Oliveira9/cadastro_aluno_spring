package com.joao.cadastro.controllers;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import com.joao.cadastro.core.usecases.ReadUseCase;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.infra.RestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        return criarRegistroAlunoUseCase.criarRegistroAluno2(alunoDto);
    }

    //ResponseEntity<AlunoDto>
    @GetMapping(value = "read")
    public ResponseEntity<AlunoDto> readRequest(@RequestBody Map<String, String> numeroDocumentoMatricula){
        return readUseCase.buscaInfoAluno((numeroDocumentoMatricula.get("numeroDocumentoMatricula")));
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<RestMessage> deleteRequest(@RequestBody Map<String, String> numeroDocumentoMatricula){
        return deleteUseCase.deletarAluno(numeroDocumentoMatricula.get("numeroDocumentoMatricula"));
    }

    @PatchMapping(value = "update")
    public ResponseEntity<RestMessage> requestUpdate(@RequestBody AlunoDto alunoDto){
        return updateUseCase.atualizarRegistroAluno(alunoDto);
    }
}
