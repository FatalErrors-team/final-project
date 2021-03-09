package com.gama.finalproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AlunoException extends RuntimeException{

    private final HttpStatus httpStatus;

    public AlunoException(final String mensagem, final HttpStatus httpStatus){
        super(mensagem);
        this.httpStatus = httpStatus;
    }
}
