package com.gama.finalproject.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gama.finalproject.entities.Administrador;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Administrador", description = "Usuário mestre do sistema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDto {

    @ApiModelProperty(value = "Identificador do administrador", allowEmptyValue = true, hidden = true)
    private Long id;

    @NotNull(message = "O nome do administrador não pode ser nulo")
    @NotEmpty(message = "O nome do administrador não pode ser vazio")
    @Size(min = 4, max = 20, message = "O nome de administrador deve ter entre 4 e 20 caracteres")
    @ApiModelProperty(value = "Nome de usuário", example = "fulaninho")
    private String usuario;

    @NotNull(message = "O senha do administrador não pode ser nula")
    @NotEmpty(message = "O senha do administrador não pode ser vazia")
    @Size(min = 4, max = 20, message = "O nome de administrador deve ter entre 8 e 20 caracteres")
    @ApiModelProperty(value = "Senha da conta", example = "senha")
    private String senha;

    @NotNull(message = "O nome do administrador não pode ser nulo")
    @NotEmpty(message = "O nome do administrador não pode ser vazio")
    @ApiModelProperty(value = "Nome do Administrador", example = "Fulaninho Fulano")
    private String nomeCompleto;

    public AdministradorDto(Administrador entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.senha = entity.getSenha();
        this.nomeCompleto = entity.getNomeCompleto();
    }

}

