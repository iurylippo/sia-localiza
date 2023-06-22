package com.sia.localiza.api.common.annotations.validation.validators;

import java.util.Arrays;

import com.sia.localiza.api.common.annotations.validation.constraints.DayPeriodType;
import com.sia.localiza.api.common.enums.EDayPeriod;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DayPeriodValidator implements ConstraintValidator<DayPeriodType, EDayPeriod> {
    private EDayPeriod[] subset;

    @Override
    public void initialize(DayPeriodType constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(EDayPeriod value, ConstraintValidatorContext context) {
        
        return value == null || Arrays.asList(subset).contains(value);
    }
}
