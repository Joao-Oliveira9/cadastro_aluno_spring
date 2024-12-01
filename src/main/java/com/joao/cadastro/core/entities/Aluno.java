package com.joao.cadastro.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;


@AllArgsConstructor
@Getter
@Setter
@Entity
public class Aluno {
/*    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;
    private String ra;

    @CreatedDate
    private Date created_at;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
//*

    public String name;
    public String age;
}
