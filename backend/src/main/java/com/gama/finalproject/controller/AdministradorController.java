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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @ApiOperation(value = "Realiza o cadastro de um usuário")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "O cadastro foi realizado"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response<Boolean>> cadastro(@ApiParam(value = "Usuário no formato JSON a ser cadastrado", required = true) @RequestBody AdministradorDto administradorDto) {
        Response<Boolean> response = new Response<Boolean>();
        administradorDto.setSenha(new BCryptPasswordEncoder().encode(administradorDto.getSenha()));
        response.setData(this.service.inserir(administradorDto));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
