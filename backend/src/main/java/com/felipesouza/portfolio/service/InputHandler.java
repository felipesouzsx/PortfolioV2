package com.felipesouza.portfolio.service;


// Declared class as "final" so it can't be subclassed
public final class InputHandler {

    // Private constructor so it can't be instantiated
    private InputHandler() {}

    public static String sanitizeString(String input) {
        return input.replaceAll("[^\\w]+", " ");
    }
}
