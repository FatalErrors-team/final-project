package com.gama.finalproject.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "O nome do aluno não pode ser nulo")
    @NotEmpty(message = "O nome do aluno não pode ser vazio")
    @Size(min = 4, message = "O nome do aluno deve ter mais de 4 caracteres")
    @ApiModelProperty(value = "Nome do aluno", example = "fulaninho")
    private String nome;

    @NotNull(message = "O email do aluno não pode ser nulo")
    @NotEmpty(message = "O email do aluno não pode ser vazio")
    @ApiModelProperty(value = "Email do aluno", example = "fulaninho@email.com")
    private String email;

    @NotNull(message = "O telefone do aluno não pode ser nulo")
    @NotEmpty(message = "O telefone do aluno não pode ser vazio")
    @ApiModelProperty(value = "Telefone do aluno", example = "990909090")
    private String telefone;

    @NotNull(message = "A primeira nota do aluno não pode ser nulo")
    @ApiModelProperty(value = "Primeira nota do aluno", example = "10")
    private Double nota01;

    @NotNull(message = "A segunda nota do aluno não pode ser nulo")
    @ApiModelProperty(value = "Segunda nota do aluno", example = "10")
    private Double nota02;

    @NotNull(message = "A nota da apresentação do aluno não pode ser nulo")
    @ApiModelProperty(value = "Nota da apresentação do aluno", example = "10")
    private Double notaApresentacao;

    @NotNull(message = "A nota do trabalho do aluno não pode ser nulo")
    @ApiModelProperty(value = "Nota do trabalho do aluno", example = "10")
    private Double notaTrabalho;

    @ApiModelProperty(value = "Média do aluno", example = "10", hidden = true)
    private Double media;

    @ApiModelProperty(value = "Conceito do aluno")
    private Conceito conceito;

    @NotNull(message = "O endereço do aluno não pode ser nulo")
    @ApiModelProperty(value = "Endereço do aluno")
    private Endereco endereco;

    @NotNull(message = "O curso do aluno não pode ser nulo")
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
        this.notaTrabalho = entity.getNotaTrabalho();
        this.media = entity.getMedia();
        this.conceito = entity.getConceito();
        this.endereco = entity.getEndereco();
        this.curso = entity.getCurso();
    }

    public Double calculaMedia(){
        return (this.getNota01() + this.getNota02()+ this.getNotaApresentacao() + this.getNotaTrabalho())/4;
    }
    public Conceito mostrarConceito(){
        if (this.calculaMedia() > 5.9){
            return Conceito.APROVADO;
        }
        return Conceito.REPROVADO;
    }
}
