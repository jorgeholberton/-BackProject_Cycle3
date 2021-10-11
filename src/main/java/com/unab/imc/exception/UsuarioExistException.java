package com.unab.imc.exception;

public class UsuarioExistException extends RuntimeException{

    public UsuarioExistException(String detail) {
        super(detail);
    }
}
