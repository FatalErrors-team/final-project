package com.gama.finalproject.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AdministradorException extends RuntimeException {
    private final HttpStatus httpStatus;

    public AdministradorException(final String mensagem, final HttpStatus httpStatus){
        super(mensagem);
        this.httpStatus = httpStatus;
    }
}