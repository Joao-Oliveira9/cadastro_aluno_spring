package com.joao.cadastro.exceptions;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
    public AlunoNotFoundException(){super("Aluno não encontrado, id inválido");}
}
