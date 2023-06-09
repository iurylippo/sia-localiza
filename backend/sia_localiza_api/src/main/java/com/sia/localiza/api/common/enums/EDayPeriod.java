package com.sia.localiza.api.common.enums;

public enum EDayPeriod  {
    MANHA("manhã"),
    TARDE("tarde"),
    NOITE("noite");

    private String value;

    EDayPeriod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
} 