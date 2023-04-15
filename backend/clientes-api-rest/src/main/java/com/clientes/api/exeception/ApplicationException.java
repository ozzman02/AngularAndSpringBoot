package com.clientes.api.exeception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private final String messageCategory;

    private final HttpStatus httpStatus;

    public ApplicationException(String messageCategory, String errorMessage, HttpStatus httpStatus){
        super(errorMessage);
        this.messageCategory = messageCategory;
        this.httpStatus = httpStatus;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
