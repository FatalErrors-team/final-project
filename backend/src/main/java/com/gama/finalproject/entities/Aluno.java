package com.gama.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Aluno", description = "Entidades de aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 5266708057520377178L;

    @ApiModelProperty(value = "Identificador do endereço", allowEmptyValue = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome do aluno", example = "fulaninho")
    private String nome;

    @ApiModelProperty(value = "Email do aluno", example = "fulaninho@email.com")
    private String email;

    @ApiModelProperty(value = "Telefone do aluno", example = "990909090")
    private String telefone;

    @ApiModelProperty(value = "Primeira nota do aluno", example = "10")
    private Double nota01;

    @ApiModelProperty(value = "Segunda nota do aluno", example = "10")
    private Double nota02;

    @ApiModelProperty(value = "Nota da apresentação do aluno", example = "10")
    private Double notaApresentacao;

    @ApiModelProperty(value = "Média do aluno", example = "10")
    private Double media;

    @ApiModelProperty(value = "Conceito do aluno")
    private Conceito conceito;

    @ApiModelProperty(value = "Endereço do aluno")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @ApiModelProperty(value = "Curso do aluno")
    @ManyToOne(cascade = CascadeType.ALL)
    private Curso curso;
}
