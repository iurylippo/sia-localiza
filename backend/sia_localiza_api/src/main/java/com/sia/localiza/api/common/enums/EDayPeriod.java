package com.sia.localiza.api.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EDayPeriod  {
    manha("manha"),
    tarde("tarde"),
    noite("noite");

    private String value;

    EDayPeriod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EDayPeriod forName(String name) {
        for(EDayPeriod c: values()) {
            if(c.name().equals(name)) {
                return c;
            }
        }

        return null;
    }
} 