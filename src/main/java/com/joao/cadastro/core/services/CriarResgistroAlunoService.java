package com.joao.cadastro.core.services;

import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import  com.joao.cadastro.core.usecases.criarRegistroAlunoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarResgistroAlunoService implements criarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public void criarRegistroAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
