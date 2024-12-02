package com.joao.cadastro.core.services;

import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CriarResgistroAlunoService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;


    @Override
    public void criarRegistroAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
