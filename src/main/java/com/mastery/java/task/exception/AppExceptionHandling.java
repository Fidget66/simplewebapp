package com.mastery.java.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandling{

    @ExceptionHandler(EntityIsNotPresentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<ApiError> handleCustomException(EntityIsNotPresentException exception) {
        return new ResponseEntity<>(getApiError(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<ApiError> handleCustomException(MethodArgumentNotValidException ex) {
        ApiError error = getApiError(ex);
        StringBuilder message= new StringBuilder("");
        for (FieldError errors : ex.getBindingResult().getFieldErrors()) {
           message.append(errors.getField() + ": " + errors.getDefaultMessage() + "; ");
        }
        for (ObjectError errors : ex.getBindingResult().getGlobalErrors()) {
            message.append(errors.getObjectName() + ": " + errors.getDefaultMessage() + "; ");
        }
        error.setMessage(message.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<ApiError> handleUnprocessedException(Exception exception) {
        return new ResponseEntity<>(getApiError(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiError getApiError(Exception ex){
        ApiError apiError = ApiError
                .builder()
                .exception(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return apiError;
    }
}
