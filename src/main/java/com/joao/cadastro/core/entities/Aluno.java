package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.print.Doc;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_Aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID aluno_id;

    @Column(name = "nome",nullable = false,unique = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "curso_id" , nullable = false
    )
    private Curso curso;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TB_Aluno_Disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina>disciplinas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id",unique = false,nullable = false)
    private DocumentoMatricula documentoMatricula;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime update_at;
}
