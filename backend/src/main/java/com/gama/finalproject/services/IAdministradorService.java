package com.gama.finalproject.services;

import com.gama.finalproject.dto.AdministradorDto;

import org.springframework.stereotype.Service;

public interface IAdministradorService {

    // public AdministradorDto buscarPorId(Long id);
    public Boolean inserir(AdministradorDto administradorDto);
    // public Boolean deletar(Long id);

}
