package com.gama.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    @ApiModelProperty(value = "Identificador do curso", hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome do curso", example = "Ciências da Computação")
    private String nome;

    @ApiModelProperty(value = "Disciplina do curso", example = "Cálculo I")
    private String disciplina;
}
