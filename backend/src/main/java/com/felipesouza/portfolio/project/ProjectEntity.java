package com.felipesouza.portfolio.project;


import com.felipesouza.util.InputHandler;
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
    @Column(name="namespace", nullable = false, unique = true)
    private String namespace;

    @Column(name="publisher", nullable = false)
    private String publisher;
    @Column(name="releaseDate", nullable = false)
    private Date releaseDate;

    @Column(name="role", nullable = false)
    private String role;


    @Override
    public String toString() {
        return String.format("[ProjectEntity %s]\n\tdescription = %s\n\tid = %s\n\tnamespace = %s\n\tpublisher = %s\n\treleaseDate = %s\n\trole = %s",
                this.name, this.description, this.id, this.namespace, this.publisher, this.releaseDate, this.role);
    }
}
