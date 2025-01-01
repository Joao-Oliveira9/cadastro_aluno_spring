package com.joao.cadastro.core.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joao.cadastro.core.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlunoDto {
    private String nome_aluno;
    private String nome_curso;
    private Integer numeroDocumentoMatricula;
    private UUID id_aluno;
    //private Set<Disciplina> disciplinas;
    private Set<RegistroNotaDto> registroNotaDtos;
}
