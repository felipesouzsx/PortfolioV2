package com.felipesouza.portfolio.controller;

import java.util.Date;

public record ProjectDTO(
        String name,
        String description,
        String namespace,
        String publisher,
        Date releaseDate,
        String role
    ) {};
