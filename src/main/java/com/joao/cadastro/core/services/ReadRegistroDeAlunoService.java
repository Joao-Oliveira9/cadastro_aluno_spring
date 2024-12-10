package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.ReadUseCase;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReadRegistroDeAlunoService extends BaseService implements ReadUseCase {
    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    public AlunoDto buscaInfoAluno(int numeroDocumento){
            if (!checarDocumentoMatricula(numeroDocumento)) {
                DocumentoMatricula documentoMatricula = documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento);
                Aluno aluno = documentoMatricula.getAluno();
                AlunoDto alunoDto = new AlunoDto(aluno.getNome(),aluno.getCurso().getNome(),aluno.getDocumentoMatricula().getNumeroDocumento(),aluno.getAluno_id());
                return  alunoDto;
            }
        throw new IllegalArgumentException("Documento inválido ou inexistente.");
    }
}
