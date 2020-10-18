package com.example.demo.validation;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, User> {

    public final UserRepository userRepository;


    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if(validUser(user)) {
            return true;
        } else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
    }

    boolean validUser(User user) {
        if (user.getId() == null) {
            return userRepository.findByEmail(user.getEmail()) == null;
        } else {
            return user.getId().equals(userRepository.findByEmail(user.getEmail()).getId());
        }
    }
}