package com.nexos.prueba.pruebanexosjavaangular.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class MercanciaException extends Exception{
    private static final long serialVersionUID = 1L;

    public MercanciaException(String message){
        super(message);
    }
}
