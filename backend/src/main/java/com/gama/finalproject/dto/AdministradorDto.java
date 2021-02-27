package com.gama.finalproject.dto;

import com.gama.finalproject.entities.Administrador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDto {

    private Long id;
    private String usuario;
    private String senha;

    public AdministradorDto(Administrador entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.senha = entity.getSenha();
    }

}

