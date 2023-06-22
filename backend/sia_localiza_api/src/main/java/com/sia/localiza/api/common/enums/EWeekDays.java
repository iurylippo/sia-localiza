package com.sia.localiza.api.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EWeekDays {
	domingo("domingo"),
	segunda("segunda")	,
	terca("terça"),
	quarta("quarta"),
	quinta("quinta"),
	sexta("sexta"),
	sabado("sábado");

	private String value;

    EWeekDays(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

	@JsonCreator
    public static EWeekDays forName(String name) {
        for(EWeekDays c: values()) {
            if(c.name().equals(name)) {
                return c;
            }
        }

        return null;
    }
}

