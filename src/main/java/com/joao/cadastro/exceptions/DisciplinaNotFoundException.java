package com.joao.cadastro.exceptions;

import com.joao.cadastro.core.entities.Disciplina;

public class DisciplinaNotFoundException extends RuntimeException {
    public DisciplinaNotFoundException(String message) {
        super(message);
    }
    public DisciplinaNotFoundException(){super("Disciplina não encontrada");}
}
