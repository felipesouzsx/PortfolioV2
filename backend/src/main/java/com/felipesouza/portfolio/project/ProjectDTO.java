package com.felipesouza.portfolio.project;

import com.felipesouza.portfolio.asset.AssetDTO;

import java.util.Date;
import java.util.List;

public record ProjectDTO(
        String id,
        String name,
        String description,
        String publisher,
        Date releaseDate,
        String roles,
        List<AssetDTO> assets
    ) {}
