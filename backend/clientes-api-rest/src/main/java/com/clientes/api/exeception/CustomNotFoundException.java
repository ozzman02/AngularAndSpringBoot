package com.clientes.api.exeception;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
