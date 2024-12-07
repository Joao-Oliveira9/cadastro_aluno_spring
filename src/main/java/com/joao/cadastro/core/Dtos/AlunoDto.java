package com.joao.cadastro.core.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {
    String nome;
    String curso;
    String numeroDocumentoMatricula;
}
