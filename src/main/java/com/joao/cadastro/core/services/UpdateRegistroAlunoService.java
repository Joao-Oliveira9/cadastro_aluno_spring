package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Aluno_Disciplina;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.Disciplina;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import com.joao.cadastro.infra.RestMessage;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.Aluno_DisciplinaRepository;
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

    @Autowired
    Aluno_DisciplinaRepository alunoDisciplinaRepository;

    @Transactional
    public ResponseEntity<RestMessage> atualizarRegistroAluno(AlunoDto alunoDto) {
        if(!checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            Aluno aluno = documentoMatriculaRepository.findBynumeroDocumento(alunoDto.getNumeroDocumentoMatricula()).getAluno();
            aluno.setCurso(cursoRealizado);

            Set<Disciplina> disciplinas = cursoRealizado.getDisciplinas();

            Set<Aluno_Disciplina> lista_aluno_disciplinas = new HashSet<>();

            for(Aluno_Disciplina aluno_disciplina : aluno.getAluno_disciplinas()){
                alunoDisciplinaRepository.delete(aluno_disciplina);
            }

            for(Disciplina disciplina : disciplinas){
                Aluno_Disciplina aluno_disciplina = new Aluno_Disciplina();
                aluno_disciplina.setAluno(aluno);
                aluno_disciplina.setDisciplina(disciplina);
                lista_aluno_disciplinas.add(aluno_disciplina);
                alunoDisciplinaRepository.save(aluno_disciplina);
            }

            aluno.setAluno_disciplinas(lista_aluno_disciplinas);

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
