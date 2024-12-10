package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;

public interface CriarRegistroAlunoUseCase extends BaseUseCase {
    String criarRegistroAluno(AlunoDto aluno);
}
