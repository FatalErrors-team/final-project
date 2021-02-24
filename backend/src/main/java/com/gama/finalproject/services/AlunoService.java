package com.gama.finalproject.services;

import com.gama.finalproject.entities.Aluno;
import com.gama.finalproject.entities.Conceito;
import com.gama.finalproject.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository repository;


    @Override
    public List<Aluno> listar() {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Aluno buscarPorId(Long id) {
        Optional<Aluno> alunoOptional = this.repository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            return aluno;
        }
        return new Aluno();
    }

    @Override
    public Boolean inserir(Aluno aluno) {
        try {
            return cadastrarOuAtualizar(aluno);
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean deletar(Long id) {
        try {
            this.repository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean atualizar(Aluno aluno) {
        try {
            return cadastrarOuAtualizar(aluno);
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    public Boolean cadastrarOuAtualizar(Aluno aluno) {
        try {
            Aluno alunoEntity = new Aluno();
            if (aluno.getId() != null) {
                alunoEntity.setId(aluno.getId());
            }

            alunoEntity.setName(aluno.getName());
            alunoEntity.setEmail(aluno.getEmail());
            alunoEntity.setTelefone(aluno.getTelefone());
            alunoEntity.setNota01(aluno.getNota01());
            alunoEntity.setNota02(aluno.getNota02());
            alunoEntity.setNotaApresentacao(aluno.getNotaApresentacao());
            alunoEntity.setMedia((aluno.getNota01()+aluno.getNota02()+aluno.getNotaApresentacao())/3);
            if (alunoEntity.getMedia() < 6){
                alunoEntity.setConceito(Conceito.REPROVADO);
            }else {
                alunoEntity.setConceito(Conceito.APROVADO);
            }
            alunoEntity.setEndereco(aluno.getEndereco());
            alunoEntity.setCurso(aluno.getCurso());

            this.repository.save(alunoEntity);

            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
