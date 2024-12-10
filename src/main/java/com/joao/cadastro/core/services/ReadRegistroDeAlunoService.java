package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.ReadUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReadRegistroDeAlunoService implements ReadUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    public AlunoDto buscaInfoAluno(int numeroDocumento){
    /*    Aluno aluno = alunoRepository.findById(id_aluno).get();
        AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),id_aluno);

        return alunoDto;*/

       DocumentoMatricula documentoMatricula = documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento);
       Aluno aluno = documentoMatricula.getAluno();
       AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),aluno.getAluno_id());
       return alunoDto;

    }
}
