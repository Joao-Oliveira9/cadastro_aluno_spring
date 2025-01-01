package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.Dtos.RegistroNotaDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Aluno_Disciplina;
import com.joao.cadastro.core.entities.Disciplina;
import com.joao.cadastro.core.usecases.UpdateNotaUseCase;

import com.joao.cadastro.exceptions.AlunoNotFoundException;
import com.joao.cadastro.exceptions.DisciplinaNotFoundException;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import com.joao.cadastro.infra.RestMessage;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.Aluno_DisciplinaRepository;
import com.joao.cadastro.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

     public ResponseEntity<RestMessage> atualizarNotaAluno(RegistroNotaDto registroNotaDto){
       if(alunoRepository.findById(registroNotaDto.getId()).isPresent()){
          Optional<Aluno> aluno = alunoRepository.findById(registroNotaDto.getId());

          if(disciplinaRepository.findByNome(registroNotaDto.getNome_disciplina()) !=null){
              Disciplina disciplina = disciplinaRepository.findByNome(registroNotaDto.getNome_disciplina());
              Aluno_Disciplina aluno_disciplina = aluno_disciplinaRepository.findByDisciplinaAndAluno(disciplina,aluno);
              aluno_disciplina.setNota(registroNotaDto.getNota());
              aluno_disciplinaRepository.save(aluno_disciplina);

              RestMessage message = new RestMessage("Nota do aluno " + aluno.get().getNome() +" em " + registroNotaDto.getNome_disciplina() + " Atualizada para " + registroNotaDto.getNota());
              return ResponseEntity.status(HttpStatus.OK).body(message);
          }
          else{
              throw new DisciplinaNotFoundException();
          }

        }
       else{
           throw new AlunoNotFoundException();
       }
    }

}
