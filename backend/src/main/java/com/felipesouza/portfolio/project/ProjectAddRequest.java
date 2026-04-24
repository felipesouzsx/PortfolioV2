package com.felipesouza.portfolio.project;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;


public record ProjectAddRequest (
     String name,
     String namespace,
     String description,
     String releaseDate,
     MultipartFile logoImage,
     MultipartFile heroImage,
     String publisher,
     String role
) {}
