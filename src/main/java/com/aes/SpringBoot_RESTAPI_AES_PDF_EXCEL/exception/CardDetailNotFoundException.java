package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.exception;

import org.springframework.http.HttpStatus;

public class CardDetailNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;

    public CardDetailNotFoundException(String message) {
        super(message);
    }

    public CardDetailNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CardDetailNotFoundException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
}