package com.sia.localiza.api.common.annotations.validation.validators;

import java.util.Arrays;

import com.sia.localiza.api.common.annotations.validation.constraints.RoleType;
import com.sia.localiza.api.modules.users.enums.Role;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleTypeValidator implements ConstraintValidator<RoleType, Role> {
    private Role[] subset;

    @Override
    public void initialize(RoleType constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Role value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
