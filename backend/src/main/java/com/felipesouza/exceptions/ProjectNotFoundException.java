package com.felipesouza.exceptions;

public class ProjectNotFoundException extends Exception {
    public ProjectNotFoundException() {}

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
