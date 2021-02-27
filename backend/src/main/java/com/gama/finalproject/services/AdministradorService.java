package com.gama.finalproject.services;

import com.gama.finalproject.dto.AdministradorDto;
import com.gama.finalproject.entities.Administrador;
import com.gama.finalproject.repositories.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private AdministradorRepository repository;

    @Override
    public Boolean inserir(AdministradorDto administradorDto) {
        try {

            Administrador administradorEntity = new Administrador();

            if (administradorDto.getId() != null) {
                administradorEntity.setId(administradorDto.getId());
            }

            administradorEntity.setUsuario(administradorDto.getUsuario());
            administradorEntity.setSenha(administradorDto.getSenha());

            this.repository.save(administradorEntity);
            return Boolean.TRUE;

        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

}
