package com.felipesouza.portfolio.project;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProjectDTOMapper implements Function<ProjectEntity, ProjectDTO> {
    @Override
    public ProjectDTO apply(ProjectEntity project) {
        return new ProjectDTO(
                project.getName(),
                project.getDescription(),
                project.getNamespace(),
                project.getPublisher(),
                project.getReleaseDate(),
                project.getRoles()
        );
    }

    public static SimpleProjectDTO simplify(ProjectDTO dto) {
        return new SimpleProjectDTO(
                dto.name(),
                dto.publisher(),
                dto.roles()
        );
    }
}
