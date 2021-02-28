package com.gama.finalproject.dto;

import com.gama.finalproject.entities.Aluno;
import com.gama.finalproject.entities.Conceito;
import com.gama.finalproject.entities.Curso;
import com.gama.finalproject.entities.Endereco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

    @ApiModelProperty(value = "Identificador do endereço", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(value = "Nome do aluno", example = "fulaninho")
    private String nome;

    @ApiModelProperty(value = "Email do aluno", example = "fulaninho@email.com")
    private String email;

    @ApiModelProperty(value = "Telefone do aluno", example = "990909090")
    private String telefone;

    @ApiModelProperty(value = "Primeira nota do aluno", example = "10")
    private Double nota01;

    @ApiModelProperty(value = "Segunda nota do aluno", example = "10")
    private Double nota02;

    @ApiModelProperty(value = "Nota da apresentação do aluno")
    private Double notaApresentacao;

    @ApiModelProperty(value = "Média do aluno", example = "10")
    private Double media;

    @ApiModelProperty(value = "Conceito do aluno")
    private Conceito conceito;

    @ApiModelProperty(value = "Endereço do aluno")
    private Endereco endereco;

    @ApiModelProperty(value = "Curso do aluno")
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

    public Double calculaMedia(){
        return (this.getNota01() + this.getNota02()+ this.getNotaApresentacao())/3;
    }
    public Conceito mostrarConceito(){
        if (this.calculaMedia() > 5.9){
            return Conceito.APROVADO;
        }
        return Conceito.REPROVADO;
    }
}
