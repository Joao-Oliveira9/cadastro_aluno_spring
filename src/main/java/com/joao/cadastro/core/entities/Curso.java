package com.joao.cadastro.core.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TB_Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_curso;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;

    @OneToMany(mappedBy = "curso",fetch = FetchType.LAZY)
    private Set<Aluno> aluno;

    //relação entre aluno e curso
    @ManyToMany
    @JoinTable(
            name = "TB_curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime update_at;

    @Column(name = "deleted_at",updatable = true)
    private LocalDateTime deleted_at;
}
