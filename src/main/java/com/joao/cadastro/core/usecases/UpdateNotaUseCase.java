package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.Dtos.RegistroNotaDto;
import com.joao.cadastro.infra.RestMessage;
import org.springframework.http.ResponseEntity;

public interface UpdateNotaUseCase {
    void atualizarNotaAluno(RegistroNotaDto registroNotaDto);
}
