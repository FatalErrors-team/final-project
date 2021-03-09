package com.gama.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.UniqueElements;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(value = "Administrador", description = "administrador mestre do sistema")
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

    @NotNull(message = "O usuario do administrador não pode ser nulo")
    @NotEmpty(message = "O usuario do administrador não pode ser vazio")
    @Size(min = 4, max = 20, message = "O usuario do administrador deve ter entre 4 e 20 caracteres")
    @Column(unique = true)
    @ApiModelProperty(value = "Nome de administrador", example = "Fulano")
    private String usuario;

    @NotNull(message = "O senha do administrador não pode ser nula")
    @NotEmpty(message = "O senha do administrador não pode ser vazia")
    @ApiModelProperty(value = "Senha da conta", example = "senha")
    private String senha;

    @NotNull(message = "O nome do administrador não pode ser nulo")
    @NotEmpty(message = "O nome do administrador não pode ser vazio")
    @Size(min = 4, max = 20, message = "O nome deve ter entre 2 e 40 caracteres")
    @ApiModelProperty(value = "Nome do Administrador", example = "Fulaninho Fulano")
    private String nomeCompleto;

}
