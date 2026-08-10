package com.felipesouza.portfolio.testimonials.dto;

import org.springframework.web.multipart.MultipartFile;

public record TestimonialUpdateRequest(
        String author,
        String role,
        String company,
        String message,
        MultipartFile picture
) {}
