package com.example.WatchlistApplcation.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAnnotationLogic.class)
public @interface Rating {
    String message() default "Jnab G rating 5 too 10 de vich vich deoo";

    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
