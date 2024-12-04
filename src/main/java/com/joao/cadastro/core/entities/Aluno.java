package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_Aluno")
public class Aluno {
    //Definição da primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID aluno_id;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime update_at;

    //nesse caso estou fazendo um soft delete- vai ser coletada a data de outra forma
    @Column(name = "deleted_at", updatable = false)
    private LocalDateTime deletedAt;
}
