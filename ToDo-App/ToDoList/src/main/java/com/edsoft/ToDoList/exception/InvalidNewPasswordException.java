package com.edsoft.ToDoList.exception;

public class InvalidNewPasswordException extends RuntimeException{
    public InvalidNewPasswordException() {
        super("The new password does not meet the required criteria.");
    }
}
