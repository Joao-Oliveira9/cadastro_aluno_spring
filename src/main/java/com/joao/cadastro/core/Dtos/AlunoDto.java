package com.joao.cadastro.core.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {
    private String nome_aluno;
    private String nome_curso;
    private String numeroDocumentoMatricula;
}