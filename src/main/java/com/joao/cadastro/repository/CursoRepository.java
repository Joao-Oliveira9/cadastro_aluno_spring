package com.joao.cadastro.repository;

import com.joao.cadastro.core.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<Curso,UUID> {
    Curso findCursoByNome(String nome);
}
