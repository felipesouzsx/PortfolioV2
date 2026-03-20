package com.felipesouza.portfolio.controller;

import com.felipesouza.portfolio.service.DateHandler;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
public class ProjectFormData {
    private String name;
    private String namespace;
    private String description;
    private String releaseDate;
    private MultipartFile logoImage;
    private MultipartFile heroImage;
    private String publisher;
    private String role;


    public ProjectDTO toDTO() {
        Date convertedReleaseDate = releaseDate != null ? DateHandler.fromString(releaseDate): null;
        return new ProjectDTO(name, description, namespace, publisher, convertedReleaseDate, role);
    }
}
