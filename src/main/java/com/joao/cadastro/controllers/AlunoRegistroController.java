package com.joao.cadastro.controllers;

import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.services.CriarResgistroAlunoService;
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
    CriarResgistroAlunoService criarResgistroAlunoService;

    @PostMapping(value = "registro")
    public void postRequestResgistroAluno(@RequestBody Aluno aluno){
        criarResgistroAlunoService.criarRegistroAluno(aluno);
        //alunoRepository.save(aluno);
        //System.out.println("Resgistrado"+ aluno.getNome());
    }
}
