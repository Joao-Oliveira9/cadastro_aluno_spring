package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
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

    //olhar aqui
    @OneToMany(mappedBy = "curso")
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
    private LocalDate created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate update_at;

    @Column(name = "deleted_at",updatable = false)
    private LocalDate deleted_at;
}
