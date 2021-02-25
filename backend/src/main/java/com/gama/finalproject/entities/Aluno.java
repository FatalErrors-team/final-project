package com.gama.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 5266708057520377178L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Double nota01;
    private Double nota02;
    private Double notaApresentacao;
    private Double media;
    private Conceito conceito;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    private Curso curso;
}
