package com.evo.course.exception.handler;

import com.evo.course.exception.LessonNotFoundException;
import com.evo.course.exception.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LessonNotFoundException.class)
    public ErrorResponse handleLessonNotFoundException(
            LessonNotFoundException exception,
            HttpServletRequest httpServletRequest) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .path(httpServletRequest.getServletPath())
                .timestamp(LocalDateTime.now())
                .build();
    }
}