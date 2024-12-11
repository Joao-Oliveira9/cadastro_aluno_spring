package com.joao.cadastro.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
//preciso extender a a exception pra ca pra ser capaz de pegar as exceptions de runtime tbm
public class ExceptionHandler extends RuntimeException{



}
