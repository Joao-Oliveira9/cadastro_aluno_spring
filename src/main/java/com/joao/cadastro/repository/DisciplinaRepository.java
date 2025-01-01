package com.joao.cadastro.repository;

import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DisciplinaRepository  extends JpaRepository<Disciplina, UUID> {
    Disciplina findByNome(String nome);
}
