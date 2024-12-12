package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.Disciplina;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import com.joao.cadastro.infra.RestMessage;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UpdateRegistroAlunoService extends BaseService implements UpdateUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public ResponseEntity<RestMessage> atualizarRegistroAluno(AlunoDto alunoDto) {
        System.out.println("Valor " + alunoDto.getNome_aluno());
        if(!checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            Aluno aluno = documentoMatriculaRepository.findBynumeroDocumento(alunoDto.getNumeroDocumentoMatricula()).getAluno();
            aluno.setCurso(cursoRealizado);

            Set<Disciplina> disciplinas = cursoRealizado.getDisciplinas();

            Set<Disciplina> copy = new HashSet<>();
            copy.addAll(disciplinas);
            aluno.setDisciplinas(copy);

            aluno.setNome(alunoDto.getNome_aluno());
            alunoRepository.save(aluno);
            RestMessage restMessage = new RestMessage("Aluno " + alunoDto.getNome_aluno() + " teve informações modificadas");
            return ResponseEntity.status(HttpStatus.OK).body(restMessage);
        }
        else {
            throw new MatriculaNotFoundExeception();
        }
    }
}
