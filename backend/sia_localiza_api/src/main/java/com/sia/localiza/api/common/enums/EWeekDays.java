package com.sia.localiza.api.common.enums;

public enum EWeekDays {
	SUNDAY("domingo"),
	MONDAY("segunda")	,
	TUESDAY("terça"),
	WEDNESDAY("quarta"),
	THURSDAY("quinta"),
	FRIDAY("sexta"),
	SATURDAY("sábado");

	private String value;

    EWeekDays(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

