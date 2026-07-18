package com.felipesouza.portfolio.testimonials;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestimonialRepository extends JpaRepository<TestimonialEntity, String> {
    Optional<TestimonialEntity> findByAuthor(String author);
    void deleteByAuthor(String author);
}
