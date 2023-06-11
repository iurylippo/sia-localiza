package com.sia.localiza.api.common.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String cause) {
        super(cause);
    }
}
