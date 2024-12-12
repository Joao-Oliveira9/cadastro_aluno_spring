package com.joao.cadastro.infra;

import com.joao.cadastro.exceptions.MatriculaFoundException;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import org.hibernate.PropertyValueException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {


  /*  @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Formato Invalido Json");
    }*/


    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<RestErrorMessage> handleIPropertyValueException(PropertyValueException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Campos Nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }


    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> MatriculaNotFoundExeceptionHandler(MatriculaNotFoundExeception exeception){
       RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }


    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> MatriculaFoundException(MatriculaFoundException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

}
