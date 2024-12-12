package com.joao.cadastro.infra;

import com.joao.cadastro.exceptions.MatriculaFoundException;
import com.joao.cadastro.exceptions.MatriculaNotFoundExeception;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidJson(HttpMessageNotReadableException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Formato Invalido Json");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<RestErrorMessage> handleIPropertyValueException(PropertyValueException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidFomat(NullPointerException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidFomatNumberMatricula(NumberFormatException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
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
