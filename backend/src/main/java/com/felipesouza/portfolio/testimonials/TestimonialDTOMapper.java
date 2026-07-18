package com.felipesouza.portfolio.testimonials;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TestimonialDTOMapper implements Function<TestimonialEntity, TestimonialDTO> {
    @Override
    public TestimonialDTO apply(TestimonialEntity testimonialEntity) {
        return new TestimonialDTO(
                testimonialEntity.getAuthor(),
                testimonialEntity.getRole(),
                testimonialEntity.getCompany(),
                testimonialEntity.getMessage()
        );
    }
}
