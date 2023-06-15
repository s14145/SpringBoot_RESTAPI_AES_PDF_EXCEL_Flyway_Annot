package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.exception;

import org.springframework.http.HttpStatus;

public class CardDetailAlreadyExistsException extends RuntimeException{

    private HttpStatus httpStatus;

    public CardDetailAlreadyExistsException(String message) {
        super(message);
    }

    public CardDetailAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CardDetailAlreadyExistsException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
}