package com.example.WatchlistApplcation.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityAnnotationLogic.class)
public @interface Priority {
    String message() default "Sirf LHM me se koi ek character likho";

    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
