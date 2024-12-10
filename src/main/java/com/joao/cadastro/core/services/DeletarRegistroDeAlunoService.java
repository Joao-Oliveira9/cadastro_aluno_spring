package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.DeleteUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class DeletarRegistroDeAlunoService implements DeleteUseCase {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Transactional
    public String deletarAluno(AlunoDto alunoDto) {
        DocumentoMatricula documentoMatricula = documentoMatriculaRepository.findBynumeroDocumento(alunoDto.getNumeroDocumentoMatricula());
        if(documentoMatricula !=null){
            Aluno aluno = documentoMatricula.getAluno();
            String nomeAlunoRemovido = aluno.getNome();
            alunoRepository.delete(aluno);
            return "Aluno " + nomeAlunoRemovido + " removido";
        }
        return "Esse numero de matricula nao esta sendo utilizado";
    }
}
