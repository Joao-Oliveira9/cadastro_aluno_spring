package com.joao.cadastro.repository;

import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisciplinaRepository  extends JpaRepository<Disciplina, UUID> {
}
