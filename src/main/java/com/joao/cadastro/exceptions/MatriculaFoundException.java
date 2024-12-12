package com.joao.cadastro.exceptions;

import org.springframework.http.ResponseEntity;

public class MatriculaFoundException extends  RuntimeException{
    public MatriculaFoundException(){
        super("Numero de matricula ja sendo utilizado");
    }
    public MatriculaFoundException(String message){
        super(message);
    }
}
