package com.joao.cadastro.controllers;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.services.CriarResgistroAlunoService;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoRegistroController {

    // AlunoRepository alunoRepository;

    @Autowired
    CriarRegistroAlunoUseCase criarRegistroAlunoUseCase;

    @PostMapping(value = "registro")
    public String postRequestResgistroAluno(@RequestBody AlunoDto alunoDto){
        System.out.println(alunoDto.getNome_aluno());
        //criarRegistroAlunoUseCase.criarRegistroAluno(alunoDto);
        return criarRegistroAlunoUseCase.criarRegistroAluno(alunoDto);
    }
}
