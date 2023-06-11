package com.sia.localiza.api.common.annotations.validation.validators;

import java.util.Arrays;

import com.sia.localiza.api.common.annotations.validation.constraints.DayWeekType;
import com.sia.localiza.api.common.enums.EWeekDays;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DayWeekValidator implements ConstraintValidator<DayWeekType, EWeekDays> {
    private EWeekDays[] subset;

    @Override
    public void initialize(DayWeekType constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(EWeekDays value, ConstraintValidatorContext context) {
        
        return value == null || Arrays.asList(subset).contains(value);
    }
}
