package com.joao.cadastro.core.usecases;

import java.util.UUID;

public interface AlunoExistenteUseCase {
    boolean verificarAlunoDeletado(UUID id_aluno);
}
