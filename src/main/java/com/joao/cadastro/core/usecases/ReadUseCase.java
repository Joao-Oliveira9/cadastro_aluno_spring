package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;

import java.util.UUID;

public interface ReadUseCase {
    AlunoDto buscaInfoAluno(int numeroDocumento);
}
