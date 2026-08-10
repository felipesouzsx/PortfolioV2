package com.felipesouza.portfolio.testimonials.dto;

import org.springframework.web.multipart.MultipartFile;

public record TestimonialAddRequest(
        String id,
        String author,
        String role,
        String company,
        String message,
        MultipartFile picture
) {}
