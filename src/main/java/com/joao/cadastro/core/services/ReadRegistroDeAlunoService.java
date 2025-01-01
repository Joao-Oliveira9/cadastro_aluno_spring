package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.Dtos.RegistroNotaDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Aluno_Disciplina;
import com.joao.cadastro.core.entities.Disciplina;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.ReadUseCase;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class ReadRegistroDeAlunoService extends BaseService implements ReadUseCase {
    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    public ResponseEntity<AlunoDto> buscaInfoAluno(String numeroDocumentoString){
            int numeroDocumento = Integer.parseInt(numeroDocumentoString);
            if (!checarDocumentoMatricula(numeroDocumento)) {
                DocumentoMatricula documentoMatricula = documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento);
                Aluno aluno = documentoMatricula.getAluno();

                Set<Disciplina> disciplinas = new HashSet<>();
                Set<RegistroNotaDto> registroNotaDtos = new HashSet<>();
                for(Aluno_Disciplina aluno_disciplina : aluno.getAluno_disciplinas()){
                    disciplinas.add(aluno_disciplina.getDisciplina());

                    RegistroNotaDto registroNotaDto = new RegistroNotaDto();
                    registroNotaDto.setNota(aluno_disciplina.getNota());
                    registroNotaDto.setNome_disciplina(aluno_disciplina.getDisciplina().getNome());

                    registroNotaDtos.add(registroNotaDto);
                    //registroNotaDtos.add()
                }



                //AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),aluno.getAluno_id(),aluno.getDisciplinas());
                //AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),aluno.getAluno_id(),disciplinas);
                AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),aluno.getAluno_id(),registroNotaDtos);

                return ResponseEntity.status(HttpStatus.OK).body(alunoDto);
            }else {
                throw new MatriculaNotFoundExeception();
            }
    }
}
