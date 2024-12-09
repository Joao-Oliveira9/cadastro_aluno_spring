package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.DocumentoMatricula;

public interface CriarRegistroAlunoUseCase {
    void criarRegistroAluno(AlunoDto aluno);
}
