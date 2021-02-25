package com.gama.finalproject.controller;

import com.gama.finalproject.dto.AlunoDto;
import com.gama.finalproject.model.Response;
import com.gama.finalproject.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService service;

    @GetMapping
    public ResponseEntity<Response<List<AlunoDto>>> listar(){
        Response<List<AlunoDto>> response = new Response<>();
        response.setData(this.service.listar());
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<AlunoDto>> buscarPorId(@PathVariable Long id){
        Response<AlunoDto> response = new Response<>();
        response.setData(this.service.buscarPorId(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Response<Boolean>> incluir(@RequestBody AlunoDto alunoDto){
        Response<Boolean> response = new Response<>();
        response.setData(this.service.inserir(alunoDto));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> alterar(@RequestBody AlunoDto alunoDto){
        Response<Boolean> response = new Response<>();
        response.setData(this.service.atualizar(alunoDto));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deletar(@PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.service.deletar(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
