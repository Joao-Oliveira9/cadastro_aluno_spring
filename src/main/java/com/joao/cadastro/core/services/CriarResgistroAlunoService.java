package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CriarResgistroAlunoService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;


   @Autowired
   CursoRepository cursoRepository;


    @Transactional
    public void criarRegistroAluno(AlunoDto alunoDto) {

        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.getNome_aluno());

        //revisar o erro que tinha dado aqui antes
        UUID id_curso = cursoRepository.findCursoByNome(alunoDto.getNome_curso()).getId_curso();
        aluno.setCurso(cursoRepository.findCursoByNome(alunoDto.getNome_curso()));

        System.out.println(id_curso);
        alunoRepository.save(aluno);
    }
}
