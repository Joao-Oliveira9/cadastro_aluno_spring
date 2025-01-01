package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.*;
import com.joao.cadastro.exceptions.MatriculaFoundException;
import com.joao.cadastro.infra.RestMessage;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;

import com.joao.cadastro.repository.Aluno_DisciplinaRepository;
import com.joao.cadastro.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CriarResgistroAlunoService extends BaseService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    Aluno_DisciplinaRepository alunoDisciplinaRepository;

    @Transactional
    public ResponseEntity<RestMessage> criarRegistroAluno(AlunoDto alunoDto) {
        if(checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Set<Disciplina> listaDeDisciplinas = cursoRealizado.getDisciplinas();

            Set<Disciplina> copy = new HashSet<>();
            copy.addAll(listaDeDisciplinas);

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);
            aluno.setDisciplinas(copy);

            alunoRepository.save(aluno);
            RestMessage message = new RestMessage("Aluno " + aluno.getNome() +" inserido");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }else{
            throw new MatriculaFoundException();
        }
    }



    @Transactional
    public ResponseEntity<RestMessage> criarRegistroAluno2(AlunoDto alunoDto) {
        if(checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Set<Disciplina> listaDeDisciplinas = cursoRealizado.getDisciplinas();

            Set<Disciplina> copy = new HashSet<>();
            copy.addAll(listaDeDisciplinas);

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);

            Set<Aluno_Disciplina> lista_aluno_disciplinas = new HashSet<>();

            for(Disciplina disciplina : copy){
                Aluno_Disciplina aluno_disciplina = new Aluno_Disciplina();
                aluno_disciplina.setAluno(aluno);
                aluno_disciplina.setDisciplina(disciplina);
                lista_aluno_disciplinas.add(aluno_disciplina);
                alunoDisciplinaRepository.save(aluno_disciplina);
                //System.out.println(aluno_disciplina.getDisciplina());
            }

            aluno.setAluno_disciplinas(lista_aluno_disciplinas);


            alunoRepository.save(aluno);
            RestMessage message = new RestMessage("Aluno " + aluno.getNome() +" inserido");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }else{
            throw new MatriculaFoundException();
        }
    }

    private DocumentoMatricula criarRegistroMatricula(int numeroMatricula){
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(numeroMatricula);
        return documentoMatricula;
    }
}
