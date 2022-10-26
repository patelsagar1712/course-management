package com.sagar.course.exception;

public class AccessRestrictedException extends RuntimeException {
    public AccessRestrictedException(String message) {
        super(String.format("Access not allowed to perform %s", message));
    }
}
