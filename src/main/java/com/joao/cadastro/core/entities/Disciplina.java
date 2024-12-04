package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_Disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Aluno> alunos;


    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDate created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate update_at;

    //soft delete
    @Column(name = "deleted_at",updatable = false)
    private LocalDate deleted_at;

}
