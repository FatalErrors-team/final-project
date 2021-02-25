package com.gama.finalproject.dto;

import com.gama.finalproject.entities.Aluno;
import com.gama.finalproject.entities.Conceito;
import com.gama.finalproject.entities.Curso;
import com.gama.finalproject.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Double nota01;
    private Double nota02;
    private Double notaApresentacao;
    private Double media;
    private Conceito conceito;

    private Endereco endereco;
    private Curso curso;

    public AlunoDto(Aluno entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.nota01 = entity.getNota01();
        this.nota02 = entity.getNota02();
        this.notaApresentacao = entity.getNotaApresentacao();
        this.media = entity.getMedia();
        this.conceito = entity.getConceito();
        this.endereco = entity.getEndereco();
        this.curso = entity.getCurso();
    }
}
