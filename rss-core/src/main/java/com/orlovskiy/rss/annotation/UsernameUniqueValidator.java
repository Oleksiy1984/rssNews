package com.orlovskiy.rss.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import com.orlovskiy.rss.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository == null || userRepository.findByName(username) == null;
    }

}
