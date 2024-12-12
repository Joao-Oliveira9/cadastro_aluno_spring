package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ReadUseCase {
    ResponseEntity<AlunoDto> buscaInfoAluno(String numeroDocumento);
}
