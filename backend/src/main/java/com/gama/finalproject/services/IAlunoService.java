package com.gama.finalproject.services;

import com.gama.finalproject.dto.AlunoDto;
import com.gama.finalproject.entities.Aluno;

import java.util.List;

public interface IAlunoService {

    public List<AlunoDto> listar();
    public AlunoDto buscarPorId(Long id);
    public Boolean inserir(AlunoDto alunoDto);
    public Boolean deletar(Long id);
    public Boolean atualizar(AlunoDto alunoDto);
}
