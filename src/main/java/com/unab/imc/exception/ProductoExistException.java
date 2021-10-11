package com.unab.imc.exception;

public class ProductoExistException extends RuntimeException{

    public ProductoExistException(String detail) {
        super(detail);
    }


}
