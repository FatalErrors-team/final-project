package com.gama.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @ApiModelProperty(value = "Identificador do Aluno", allowEmptyValue = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do aluno não pode ser nulo")
    @Size(min = 4, message = "O nome do aluno deve ter mais de 4 caracteres")
    @ApiModelProperty(value = "Nome do aluno", example = "fulaninho")
    private String nome;

    @NotNull(message = "O email do aluno não pode ser nulo")
    @ApiModelProperty(value = "Email do aluno", example = "fulaninho@email.com")
    private String email;

    @NotNull(message = "O telefone do aluno não pode ser nulo")
    @Size(min = 8, message = "O telefone do aluno deve ter no mínimo 8 caracteres")
    @ApiModelProperty(value = "Telefone do aluno", example = "990909090")
    private String telefone;

    @NotNull(message = "A primeira nota do aluno não pode ser nulo")
    @ApiModelProperty(value = "Primeira nota do aluno", example = "10")
    private Double nota01;

    @NotNull(message = "A segunda nota do aluno não pode ser nulo")
    @ApiModelProperty(value = "Segunda nota do aluno", example = "10")
    private Double nota02;

    @NotNull(message = "A nota da apresentação do aluno não pode ser nulo")
    @ApiModelProperty(value = "Nota da apresentação do aluno", example = "10")
    private Double notaApresentacao;

    @NotNull(message = "A nota do trabalho do aluno não pode ser nulo")
    @ApiModelProperty(value = "Nota do trabalho do aluno", example = "10")
    private Double notaTrabalho;

    @ApiModelProperty(value = "Média do aluno", example = "10", hidden = true)
    private Double media;

    @ApiModelProperty(value = "Conceito do aluno")
    private Conceito conceito;

    @NotNull(message = "O endereço do aluno não pode ser nulo")
    @ApiModelProperty(value = "Endereço do aluno")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotNull(message = "O curso do aluno não pode ser nulo")
    @ApiModelProperty(value = "Curso do aluno")
    @ManyToOne(cascade = CascadeType.ALL)
    private Curso curso;
}
