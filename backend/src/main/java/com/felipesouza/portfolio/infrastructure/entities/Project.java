package com.felipesouza.portfolio.infrastructure.entities;


import com.felipesouza.portfolio.controller.ProjectDTO;
import com.felipesouza.portfolio.service.InputHandler;
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


public class Project {

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
        return String.format("[Project %s]\n\tdescription = %s\n\tid = %s\n\tnamespace = %s\n\tpublisher = %s\n\treleaseDate = %s\n\trole = %s",
                this.name, this.description, this.id, this.namespace, this.publisher, this.releaseDate, this.role);
    }


    /**
     * @return A {@code ProjectDTO} with this Project's values.
     */
    public ProjectDTO toDTO() {
        return new ProjectDTO(
                this.getName(),
                this.getDescription(),
                this.getNamespace(),
                this.getPublisher(),
                this.getReleaseDate(),
                this.getRole()
        );
    }

    /**
     * Returns a {@code Project} that takes the values from a {@code ProjectDTO}.
     * @param dto The ProjectDTO
     * @return A new Project
     */
    public static Project fromDTO(ProjectDTO dto) {
        return Project.builder()
                .name(InputHandler.sanitizeString(dto.name()))
                .namespace(InputHandler.sanitizeString(dto.namespace()))
                .description(InputHandler.sanitizeString(dto.description()))
                .publisher(InputHandler.sanitizeString(dto.publisher()))
                .releaseDate(dto.releaseDate())
                .role(InputHandler.sanitizeString(dto.role()))
                .build();
    }

    /**
     * Returns a Project based on the values from editedProjectDTO. If any of these values is Null, falls back to the
     * values from currentProjectDTO, essentially "editing" the ProjectDTO.
     *
     * @param id The ID of the project to be edited.
     * @param currentProjectDTO The current project DTO.
     * @param editedProjectDTO A DTO with the new values.
     * @return {@code Project} with edited values.
     */
    public static Project editFromAnother(String id, ProjectDTO currentProjectDTO, ProjectDTO editedProjectDTO) {
        return Project.builder()
                .id(id)
                .name(editedProjectDTO.name() != null ? editedProjectDTO.name() : currentProjectDTO.name())
                .description(editedProjectDTO.description() != null ? editedProjectDTO.description() : currentProjectDTO.description())
                .namespace(editedProjectDTO.namespace() != null ? editedProjectDTO.namespace() : currentProjectDTO.namespace())
                .publisher(editedProjectDTO.publisher() != null ? editedProjectDTO.publisher() : currentProjectDTO.publisher())
                .releaseDate(editedProjectDTO.releaseDate() != null ? editedProjectDTO.releaseDate() : currentProjectDTO.releaseDate())
                .role(editedProjectDTO.role() != null ? editedProjectDTO.role() : currentProjectDTO.role())
                .build();
    }
}
