package com.felipesouza.portfolio.project;

import org.springframework.web.multipart.MultipartFile;


public record ProjectAddRequest (
     String name,
     String description,
     String releaseDate,
     MultipartFile logoImage,
     MultipartFile heroImage,
     String publisher,
     String roles
) {}
