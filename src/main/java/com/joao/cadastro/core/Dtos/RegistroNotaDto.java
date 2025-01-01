package com.joao.cadastro.core.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.joao.cadastro.core.entities.Disciplina;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistroNotaDto{
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
    private UUID id;
    private float nota;
    private String nome_disciplina;
}
