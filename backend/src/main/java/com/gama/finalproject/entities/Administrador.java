package com.gama.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(value = "Administrador", description = "Usuário mestre do sistema")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Administrador {

    @ApiModelProperty(value = "Identificador do administrador", allowEmptyValue = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome de usuário", example = "Fulano")
    private String usuario;

    @ApiModelProperty(value = "Senha da conta", example = "senha")
    private String senha;

}
