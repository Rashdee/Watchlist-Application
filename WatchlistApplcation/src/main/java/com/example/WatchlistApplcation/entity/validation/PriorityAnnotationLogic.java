package com.example.WatchlistApplcation.entity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class PriorityAnnotationLogic implements ConstraintValidator<Priority, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.trim().length()==1 && "LHM".contains(value.trim());
    }
}
