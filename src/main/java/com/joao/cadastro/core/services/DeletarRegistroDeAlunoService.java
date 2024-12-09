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

    //shadow delete, preciso sinalizar quando aquele aluno nao deve ser mais lido nas consultas ao banco de dados
    @Transactional
    public void deletarAluno(AlunoDto alunoDto) {
        Aluno aluno = buscarAluno(alunoDto.getNome_aluno());

        LocalDateTime dataDeExclusao = LocalDateTime.now();

        //vai setar a data do ato de deletar na base de dados nas duas tabelas
        aluno.setDeletedAt(dataDeExclusao);
        DeletarDocumentoMatricula(aluno,dataDeExclusao);

        System.out.println("Data"+ aluno.getDeletedAt());

        alunoRepository.save(aluno);
    }

    private Aluno buscarAluno(String nome){
        return alunoRepository.findByNome(nome);
    }

    private void DeletarDocumentoMatricula(Aluno aluno,LocalDateTime dataDeExclusao){
       DocumentoMatricula documentoMatricula =  aluno.getDocumentoMatricula();
       documentoMatricula.setDeleted_at(dataDeExclusao);
       documentoMatriculaRepository.save(documentoMatricula);
    }
}
