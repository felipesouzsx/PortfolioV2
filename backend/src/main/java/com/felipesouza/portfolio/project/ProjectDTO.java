package com.felipesouza.portfolio.project;

import java.util.Date;

public record ProjectDTO(
        String name,
        String description,
        String namespace,
        String publisher,
        Date releaseDate,
        String roles
    ) {}