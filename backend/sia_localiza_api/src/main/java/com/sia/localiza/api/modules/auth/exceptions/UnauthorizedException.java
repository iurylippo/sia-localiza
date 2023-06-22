package com.sia.localiza.api.modules.auth.exceptions;

public class UnauthorizedException extends Exception {
    public UnauthorizedException() {
        super("Unauthorized!");
    }
}
