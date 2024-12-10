package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlunoExistenteUseCaseImpl {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;


    //Trocar por exceptions
    public boolean checarDocumentoMatricula(int numeroDocumento){
        if(documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento) == null){
            return true;
        }
        return false;
    }
}
