package com.mastery.java.task.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private String message;
    private Exception exception;
    private LocalDateTime timestamp;
}
