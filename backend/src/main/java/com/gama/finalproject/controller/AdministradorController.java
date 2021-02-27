package com.gama.finalproject.controller;

import com.gama.finalproject.dto.AdministradorDto;
import com.gama.finalproject.model.Response;
import com.gama.finalproject.services.AdministradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorService service;


    @PostMapping("/cadastro")
    public ResponseEntity<Response<Boolean>> cadastro(@RequestBody AdministradorDto administradorDto) {
        Response<Boolean> response = new Response<Boolean>();
        administradorDto.setSenha(new BCryptPasswordEncoder().encode(administradorDto.getSenha()));
        response.setData(this.service.inserir(administradorDto));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
