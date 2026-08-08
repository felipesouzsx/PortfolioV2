package com.felipesouza.portfolio.project;

import java.util.Date;

public record ProjectDTO(
        String id,
        String name,
        String description,
        String publisher,
        Date releaseDate,
        String roles
    ) {}
