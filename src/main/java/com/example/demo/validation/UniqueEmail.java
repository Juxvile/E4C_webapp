package com.example.demo.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidation.class)
public @interface UniqueEmail {

    String message() default "Enter the unique email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}