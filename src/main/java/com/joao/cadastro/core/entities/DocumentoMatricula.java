package com.joao.cadastro.core.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TB_DocumentoMatricula")
public class DocumentoMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "numeroDocumento",nullable = false,unique = true)
    private int numeroDocumento;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @OneToOne(mappedBy = "documentoMatricula")
    private Aluno aluno;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at",updatable = false)
    private LocalDateTime deleted_at;
}
