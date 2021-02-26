package com.gama.finalproject.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.RepresentationModel;

@Primary
@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> extends RepresentationModel<Response<T>> {

    private int statusCode;
    private T data;
    private Long timeStamp;

    public Response(){
        this.timeStamp = System.currentTimeMillis();
    }
}
