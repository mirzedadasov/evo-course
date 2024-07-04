package com.evo.course.exception;

import org.springframework.validation.Errors;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException(String message) {
        super(message);
    }

    public Errors getBindingResult() {
        return null;
    }
}
