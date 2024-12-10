package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.entities.Curso;

public interface BaseUseCase {
    boolean checarDocumentoMatricula(int numeroDocumento);
    Curso buscarCurso(String nomeCurso);
}
