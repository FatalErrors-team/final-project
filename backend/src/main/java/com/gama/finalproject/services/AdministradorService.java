package com.gama.finalproject.services;

import java.util.Optional;

import javax.validation.ValidatorFactory;

import com.gama.finalproject.dto.AdministradorDto;
import com.gama.finalproject.entities.Administrador;
import com.gama.finalproject.exception.AdministradorException;
import com.gama.finalproject.repositories.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements IAdministradorService {

    private final String ADMINISTRADOR_NAO_ENCONTRADO = "Administrador Não Encontrado";
    private final String ERRO_INTERNO_DO_SERVIDOR = "Erro Interno do Servidor";

    @Autowired
    private AdministradorRepository repository;

    @Override
    public AdministradorDto buscarPorUsuario(String usuario) {
        try{
            Optional<Administrador> alunoOptional = this.repository.findByUsuario(usuario);
            if (alunoOptional.isPresent()) {
                return new AdministradorDto(alunoOptional.get());
            }
            throw new AdministradorException(ADMINISTRADOR_NAO_ENCONTRADO, HttpStatus.NOT_FOUND);
        }catch (AdministradorException e){
            throw e;
        }catch (Exception e){
            throw new AdministradorException(ERRO_INTERNO_DO_SERVIDOR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean inserir(AdministradorDto administradorDto) {
        try {

            Administrador administradorEntity = new Administrador();

            if (administradorDto.getId() != null) {
                administradorEntity.setId(administradorDto.getId());
            }

            administradorEntity.setUsuario(administradorDto.getUsuario());
            administradorEntity.setSenha(administradorDto.getSenha());
            administradorEntity.setNomeCompleto(administradorDto.getNomeCompleto());

            this.repository.save(administradorEntity);
            return Boolean.TRUE;

        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

}
