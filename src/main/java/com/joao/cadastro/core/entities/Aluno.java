package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Aluno")
public class Aluno {
    //Definição da primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID aluno_id;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;
}
