package com.gama.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Endereço", description = "Endereço de um usuário")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

    @ApiModelProperty(value = "Identificador do endereço", allowEmptyValue = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "CEP do endereço", example = "00000-00")
    private String CEP;

    @ApiModelProperty(value = "Logradouro do endereço", example = "rua x, bairro x...")
    private String logradouro;

    @ApiModelProperty(value = "Número do endereço", example = "99")
    private int numero;
}
