package com.gama.finalproject.services;

import com.gama.finalproject.dto.AlunoDto;
import com.gama.finalproject.entities.Aluno;
import com.gama.finalproject.entities.Conceito;
import com.gama.finalproject.exception.AlunoException;
import com.gama.finalproject.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService implements IAlunoService {

    private final String ALUNO_NAO_ENCONTRADO = "ALUNO NAO ENCONTRADO";
    private final String ERRO_INTERNO_DO_SERVIDOR = "ERRO INTERNO DO SERVIDOR";

    @Autowired
    private AlunoRepository repository;


    @Override
    public List<AlunoDto> listar() {
        try {
            List<Aluno> list = this.repository.findAll();

            return list.stream().map(aluno -> new AlunoDto(aluno)).collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public AlunoDto buscarPorId(Long id) {
        try{


            Optional<Aluno> alunoOptional = this.repository.findById(id);
            if (alunoOptional.isPresent()) {
                return new AlunoDto(alunoOptional.get());
            }
            throw new AlunoException(ALUNO_NAO_ENCONTRADO, HttpStatus.NOT_FOUND);
        }catch (AlunoException e){
            throw e;
        }catch (Exception e){
            throw new AlunoException(ERRO_INTERNO_DO_SERVIDOR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean inserir(AlunoDto alunoDto) {
        try {
            return cadastrarOuAtualizar(alunoDto);
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
    public Boolean atualizar(AlunoDto alunoDto) {
        try {

            return cadastrarOuAtualizar(alunoDto);
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    public Boolean cadastrarOuAtualizar(AlunoDto alunoDto) {
        try {
            Aluno alunoEntity = new Aluno();

            if (alunoDto.getId() != null) {
                alunoEntity.setId(alunoDto.getId());
            }

            alunoEntity.setNome(alunoDto.getNome());
            alunoEntity.setEmail(alunoDto.getEmail());
            alunoEntity.setTelefone(alunoDto.getTelefone());
            alunoEntity.setNota01(alunoDto.getNota01());
            alunoEntity.setNota02(alunoDto.getNota02());
            alunoEntity.setNotaApresentacao(alunoDto.getNotaApresentacao());
            alunoEntity.setMedia((alunoDto.getNota01()+alunoDto.getNota02()+alunoDto.getNotaApresentacao())/3);
            if (alunoEntity.getMedia() < 6){
                alunoEntity.setConceito(Conceito.REPROVADO);
            }else {
                alunoEntity.setConceito(Conceito.APROVADO);
            }
            alunoEntity.setEndereco(alunoDto.getEndereco());
            alunoEntity.setCurso(alunoDto.getCurso());

            this.repository.save(alunoEntity);

            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
