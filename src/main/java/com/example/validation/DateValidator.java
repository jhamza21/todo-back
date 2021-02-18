package com.example.validation;

import com.example.entities.Todo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<DateRange, Todo> {

    @Override
    public boolean isValid(Todo todo, ConstraintValidatorContext constraintValidatorContext) {
        if(todo.getEndDate().isBefore(todo.getStartDate())||todo.getStartDate().isBefore(LocalDate.now())) return false;
        return true;
    }
}
