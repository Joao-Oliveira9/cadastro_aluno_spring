package com.joao.cadastro.exceptions;

public class MatriculaNotFoundExeception  extends RuntimeException{
    public MatriculaNotFoundExeception(){
        super("Numero de Matricula não encontrado");
    }
    public MatriculaNotFoundExeception(String message){
        super(message);
    }
}
