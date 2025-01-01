package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.Dtos.RegistroNotaDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.UpdateNotaUseCase;

import com.joao.cadastro.infra.RestMessage;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.Aluno_DisciplinaRepository;
import com.joao.cadastro.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateNotaService extends BaseService implements UpdateNotaUseCase {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    Aluno_DisciplinaRepository aluno_disciplinaRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

   /* public ResponseEntity<RestMessage> atualizarNotaAluno(RegistroNotaDto registroNotaDto){

       if(alunoRepository.findById(registroNotaDto.getId()).isPresent()){
           //Optional<Aluno> aluno = alunoRepository.findById(registroNotaDto.getId());
           disciplinaRepository.find

        }

        //aluno_disciplinaRepository.find
    }*/

     public void atualizarNotaAluno(RegistroNotaDto registroNotaDto){
       if(alunoRepository.findById(registroNotaDto.getId()).isPresent()){
           //Optional<Aluno> aluno = alunoRepository.findById(registroNotaDto.getId());
          System.out.println(disciplinaRepository.findByNome(registroNotaDto.getNome_disciplina()).getNome());
        }

        //aluno_disciplinaRepository.find
    }

}
