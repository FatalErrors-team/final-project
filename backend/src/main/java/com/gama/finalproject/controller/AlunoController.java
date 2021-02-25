package com.gama.finalproject.controller;

import com.gama.finalproject.dto.AlunoDto;
import com.gama.finalproject.entities.Aluno;
import com.gama.finalproject.entities.Conceito;
import com.gama.finalproject.entities.Curso;
import com.gama.finalproject.entities.Endereco;
import com.gama.finalproject.repositories.AlunoRepository;
import com.gama.finalproject.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoDto>> listar(){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> incluir(@RequestBody AlunoDto alunoDto){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.inserir(alunoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> alterar(@RequestBody AlunoDto alunoDto){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.atualizar(alunoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.deletar(id));
    }

}
