package com.joao.cadastro.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class RestMessage {
    private final HttpStatus status = HttpStatus.OK;
    private String message;
}
