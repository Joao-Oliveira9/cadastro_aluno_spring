package com.joao.cadastro.core.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {
    String nome_aluno;
    String nome_curso;
    String numeroDocumentoMatricula;
}
