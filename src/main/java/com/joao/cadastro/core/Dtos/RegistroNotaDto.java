package com.joao.cadastro.core.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joao.cadastro.core.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistroNotaDto{
    private UUID id;
    private float nota;
    private String nome_disciplina;
}
