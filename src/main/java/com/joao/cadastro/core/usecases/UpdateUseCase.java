package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.infra.RestMessage;
import org.springframework.http.ResponseEntity;

public interface UpdateUseCase extends BaseUseCase {
    ResponseEntity<RestMessage> atualizarRegistroAluno(AlunoDto alunoDto);
}
