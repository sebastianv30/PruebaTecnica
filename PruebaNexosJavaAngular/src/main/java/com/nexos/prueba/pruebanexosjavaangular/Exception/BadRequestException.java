package com.nexos.prueba.pruebanexosjavaangular.Exception;

public class BadRequestException extends Exception{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
