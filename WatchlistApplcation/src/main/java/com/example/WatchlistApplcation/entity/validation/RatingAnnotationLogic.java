package com.example.WatchlistApplcation.entity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RatingAnnotationLogic implements ConstraintValidator<Rating, Float> {
    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        return value>5&&value<=10;
    }
}
