package com.sia.localiza.api.common.annotations.validation.validators;

import java.util.UUID;

import com.sia.localiza.api.common.annotations.validation.constraints.UUIDType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UUIDTypeValidator implements ConstraintValidator<UUIDType, UUID> {
    private final String regex = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";

    @Override
    public void initialize(UUIDType validUuid) { }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext cxt) {
        return uuid == null || uuid.toString().matches(this.regex);
    }
}
