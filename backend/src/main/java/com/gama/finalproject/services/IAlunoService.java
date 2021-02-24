package com.gama.finalproject.services;

import com.gama.finalproject.entities.Aluno;

import java.util.List;

public interface IAlunoService {

    public List<Aluno> listar();
    public Aluno buscarPorId(Long id);
    public Boolean inserir(Aluno aluno);
    public Boolean deletar(Long id);
    public Boolean atualizar(Aluno aluno);
}
