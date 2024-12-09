package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;

public interface DeleteUseCase {
    void deletarAluno(AlunoDto alunoDto);
}
