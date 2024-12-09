package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class DeletarRegistroDeAlunoService implements DeleteUseCase {

    @Autowired
    AlunoRepository alunoRepository;

    //shadow delete, preciso sinalizar quando aquele aluno nao deve ser mais lido nas consultas ao banco de dados
    @Transactional
    public void deletarAluno(AlunoDto alunoDto) {
        Aluno aluno = buscarAluno(alunoDto.getNome_aluno());

        aluno.setDeletedAt(LocalDateTime.now());
        System.out.println("Data"+ aluno.getDeletedAt());

        alunoRepository.save(aluno);
    }

    private Aluno buscarAluno(String nome){
        return alunoRepository.findByNome(nome);
    }
}
