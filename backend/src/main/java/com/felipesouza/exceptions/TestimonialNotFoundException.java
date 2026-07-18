package com.felipesouza.exceptions;

public class TestimonialNotFoundException extends RuntimeException {
    public TestimonialNotFoundException() {
        this("Author not found");
    }

    public TestimonialNotFoundException(String message) {
        super(message);
    }
}
