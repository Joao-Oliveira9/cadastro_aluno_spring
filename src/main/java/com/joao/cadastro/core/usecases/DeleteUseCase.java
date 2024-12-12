package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.infra.RestMessage;
import org.springframework.http.ResponseEntity;

public interface DeleteUseCase {
    ResponseEntity<RestMessage> deletarAluno(AlunoDto alunoDto);
}
