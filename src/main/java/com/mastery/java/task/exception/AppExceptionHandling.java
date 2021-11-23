package com.mastery.java.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandling{

    @ExceptionHandler(EntityIsNotPresentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<ApiError> handleCustomException(RuntimeException exception) {
        return new ResponseEntity<>(getApiError(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<ApiError> handleUnprocessedException(Exception exception) {
        return new ResponseEntity<>(getApiError(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiError getApiError(Exception ex){
        ApiError apiError = ApiError
                .builder()
                .exception(ex)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return apiError;
    }
}
