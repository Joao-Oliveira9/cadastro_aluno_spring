package com.joao.cadastro.repository;

import com.joao.cadastro.core.entities.DocumentoMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentoMatriculaRepository extends JpaRepository<DocumentoMatricula, UUID> {
    DocumentoMatricula findBynumeroDocumento(int numeroDocumento);
}
