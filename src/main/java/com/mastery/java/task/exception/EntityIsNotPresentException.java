package com.mastery.java.task.exception;

public class EntityIsNotPresentException extends RuntimeException {
    public EntityIsNotPresentException(String message){
        super("This record does not exist in the database");
    }
}
