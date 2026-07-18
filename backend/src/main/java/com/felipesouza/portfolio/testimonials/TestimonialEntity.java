package com.felipesouza.portfolio.testimonials;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="testimonials")
@Entity
public class TestimonialEntity {
    @Id
    private String id;

    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "company", nullable = false)
    private String company;
    @Column(name = "message", nullable = false)
    private String message;
}
