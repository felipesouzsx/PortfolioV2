package com.felipesouza.portfolio.project;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="projects")
@Entity


public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;

    @Column(name="publisher", nullable = false)
    private String publisher;
    @Column(name="releaseDate", nullable = false)
    private Date releaseDate;

    @Column(name="roles", nullable = false)
    private String roles;


    @Override
    public String toString() {
        return String.format("[ProjectEntity %s]\n\tdescription = %s\n\tid = %s\n\tpublisher = %s\n\treleaseDate = %s\n\troles = %s",
                this.name, this.description, this.id, this.publisher, this.releaseDate, this.roles);
    }
}
