package com.gama.finalproject.dto;

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

    @ApiModelProperty(value = "Identificador do administrador", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(value = "Nome de usuário", example = "fulaninho")
    private String usuario;

    @ApiModelProperty(value = "Senha da conta", example = "senha")
    private String senha;

    public AdministradorDto(Administrador entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.senha = entity.getSenha();
    }

}

