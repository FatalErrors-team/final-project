package com.gama.finalproject.controller;

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
    public ResponseEntity<List<Aluno>> listar(){


        return ResponseEntity.status(HttpStatus.OK).body(this.service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> incluir(@RequestBody Aluno aluno){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.inserir(aluno));
    }

}
