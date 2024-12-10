package com.joao.cadastro.core.services;

import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.usecases.BaseUseCase;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseService implements BaseUseCase {
    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Autowired
    CursoRepository cursoRepository;

    public boolean checarDocumentoMatricula(int numeroDocumento){
        if(documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento) == null){
            return true;
        }
        return false;
    }

    public Curso buscarCurso(String nomeCurso){
        return cursoRepository.findByNome(nomeCurso);
    }
}
