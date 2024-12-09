package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UpdateRegistroAlunoService implements UpdateUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public void atualizarRegistroAluno(AlunoDto alunoDto) {
        String nomeCurso = alunoDto.getNome_curso();
        Curso cursoRealizado = buscarCurso(nomeCurso);
        DocumentoMatricula documentoMatricula = atualizarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

        Aluno aluno = new Aluno();
        aluno.setCurso(cursoRealizado);
        aluno.setNome(alunoDto.getNome_aluno());
        aluno.setDocumentoMatricula(documentoMatricula);

        alunoRepository.save(aluno);
    }

    //buscar uma entidade curso na base de dados com base no nome
    private Curso buscarCurso(String nomeCurso){
        return cursoRepository.findCursoByNome(nomeCurso);
    }

    //cria uma entidade matricula
    private DocumentoMatricula atualizarRegistroMatricula(String numeroMatricula){
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(Integer.parseInt(numeroMatricula));
        System.out.println(documentoMatricula.getNumeroDocumento());
        return documentoMatricula;
    }

}
