package com.gama.finalproject.controller;

import java.net.http.HttpRequest;

import javax.validation.Valid;

import com.gama.finalproject.dto.AdministradorDto;
import com.gama.finalproject.model.Response;
import com.gama.finalproject.services.AdministradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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

    @ApiOperation(value = "Retorna os dados de um administrador atráves do token no cabeçalho")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Os dados retornaram normalmente"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/administrador", produces = "application/json")
    public ResponseEntity<Response<AdministradorDto>> get(@RequestAttribute("usuario") String usuario) {
        Response<AdministradorDto> response = new Response<AdministradorDto>();
        response.setData(service.buscarPorUsuario(usuario));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiOperation(value = "Realiza o cadastro de um administrador")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "O cadastro foi realizado"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 409, message = "O Administrador já existe"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response<String>> cadastro(@Valid @ApiParam(value = "administrador no formato JSON a ser cadastrado", required = true) @RequestBody AdministradorDto administradorDto) {
        Response<String> response = new Response<String>();
        administradorDto.setSenha(new BCryptPasswordEncoder().encode(administradorDto.getSenha()));
        HttpStatus status;
        if (this.service.inserir(administradorDto)) {
            response.setData("Administrador cadastrado com sucesso");
            status = HttpStatus.CREATED;
        } else {
            response.setData("O administrador já existe!");
            status = HttpStatus.CONFLICT;
        }
        response.setStatusCode(status.value());
        response.add(Link.of("/login", "Login"));
        return ResponseEntity.status(status).body(response);
    }

    @ApiOperation(value = "Realiza login na API")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O login foi bem sucedido e você recebeu um token"),
        @ApiResponse(code = 403, message = "Você não passou dados corretos"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/login", consumes = "application/json")
    public void login(@Valid @ApiParam(value = "administrador e Senha no formato JSON", required = true) @RequestBody AdministradorDto administradorDto) {

    }

}
