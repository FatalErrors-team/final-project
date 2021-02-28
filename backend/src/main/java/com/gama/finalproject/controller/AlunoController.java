package com.gama.finalproject.controller;

import com.gama.finalproject.dto.AlunoDto;
import com.gama.finalproject.model.Response;
import com.gama.finalproject.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService service;

    @ApiOperation(value = "Retorna uma lista com todos alunos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response<List<AlunoDto>>> listar(){
        Response<List<AlunoDto>> response = new Response<>();
        response.setData(this.service.listar());
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiOperation(value = "Retorna um único aluno parametrizado pelo id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o aluno"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response<AlunoDto>> buscarPorId(@ApiParam(value = "Id do usuário a ser buscado", required = true, example = "0") @PathVariable Long id){
        Response<AlunoDto> response = new Response<>();
        response.setData(this.service.buscarPorId(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiOperation(value = "Cadastra um aluno")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "O cadastro foi realizado"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response<Boolean>> incluir(@ApiParam(value = "Aluno no formato JSON a ser cadastrado", required = true) @RequestBody AlunoDto alunoDto){
        Response<Boolean> response = new Response<>();
        response.setData(this.service.inserir(alunoDto));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Atualiza os dados de um aluno")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "A atualização foi realizada"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response<Boolean>> alterar(@ApiParam(value = "Aluno no formato JSON a ser cadastrado") @RequestBody AlunoDto alunoDto) {
        Response<Boolean> response = new Response<>();
        response.setData(this.service.atualizar(alunoDto));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiOperation(value = "Exclui um aluno através do id")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "O aluno foi excluído"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deletar(@ApiParam(value = "Id do aluno a ser excluído", required = true, example = "0") @PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.service.deletar(id));
        response.setStatusCode(HttpStatus.NO_CONTENT.value());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
