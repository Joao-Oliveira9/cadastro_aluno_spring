package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;

public interface UpdateUseCase extends BaseUseCase {
    String atualizarRegistroAluno(AlunoDto alunoDto);
}
