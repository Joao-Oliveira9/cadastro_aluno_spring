package com.joao.cadastro.repository;

import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Aluno_Disciplina;
import com.joao.cadastro.core.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Aluno_DisciplinaRepository extends JpaRepository<Aluno_Disciplina, UUID> {
    Aluno_Disciplina findBydisciplinaAndAluno(Disciplina disciplina, Aluno aluno);
}
