package com.felipesouza.portfolio.service;


import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.portfolio.controller.ProjectDTO;
import com.felipesouza.portfolio.infrastructure.entities.Project;
import com.felipesouza.portfolio.infrastructure.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }


    /**
     * Finds a project based on it's namespace and returns it's ID.
     * @param namespace The Project's namespace.
     * @return The Project's ID (UUIDv4).
     * @throws ProjectNotFoundException When the namespace doesn't belong to any Project.
     */
    private String getProjectId(String namespace) throws ProjectNotFoundException {
        Project project = repository.findByNamespace(namespace)
                .orElseThrow(() -> new ProjectNotFoundException("Namespace doesn't belong to any Project"));
        return project.getId();
    }

    /**
     * Gets the Project with the given ID.
     * @param projectId The Project's ID (UUIDv4).
     * @return The DTO of the Project.
     * @throws ProjectNotFoundException When the ID doesn't belong to any Project.
     */
    public ProjectDTO getProjectById(String projectId) throws ProjectNotFoundException {
        return this.repository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("ID not found"))
                .toDTO();
    }

    // Pretty self explainatory tbh wont make a doc out of this
    public void saveProject(Project project) {
        this.repository.saveAndFlush(project);
    }

    /**
     * @return The DTO's of all Projects.
     */
    public List<ProjectDTO> getProjects() {
        List<ProjectDTO> result = new ArrayList<>();
        this.repository.findAll().forEach(project -> result.add(project.toDTO()));
        return result;
    }

    /**
     * Deletes the Project with given ID.
     * @param projectId The Project's ID (UUIDv4).
     */
    public void deleteProjectById(String projectId) {
        this.repository.deleteById(projectId);
    }

    /**
     * Updates the Project with the given ID.
     * @param id The Project's ID (UUIDv4).
     * @param modifiedProjectDTO The DTO that contains the changes to be applied.
     * @throws ProjectNotFoundException When the ID doesn't belong to any Project.
     */
    public void updateProjectById(String id, ProjectDTO modifiedProjectDTO) throws ProjectNotFoundException
    {
        try {
            ProjectDTO oldProject = this.getProjectById(id);
            Project updatedProject = Project.editFromAnother(id, oldProject, modifiedProjectDTO);
            this.saveProject(updatedProject);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }


    /**
     * Gets the Project with the given Namespace.
     * @param namespace The namespace of the project.
     * @return The Project's {@code ProjectDTO}.
     * @throws ProjectNotFoundException When the namespace doesn't belong to any Project.
     */
    public ProjectDTO getProjectByNamespace(String namespace) throws ProjectNotFoundException {
        try {
            String projectId = this.getProjectId(namespace);
            return this.getProjectById(projectId);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Updates the Project with the given Namespace
     * @param namespace The namespace of the project.
     * @param newProjectDTO The modified ProjectDTO.
     * @throws ProjectNotFoundException When the namespace doesn't belong to any Project.
     */
    public void updateProjectByNamespace(String namespace, ProjectDTO newProjectDTO) throws ProjectNotFoundException {
        try {
            String projectId = this.getProjectId(namespace);
            updateProjectById(projectId, newProjectDTO);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Deletes the Project with the given Namespace.
     * @param namespace The namespace of the Project.
     * @throws RuntimeException When the namespace doesn't belong to any Project.
     */
    public void deleteProjectByNamespace(String namespace) throws ProjectNotFoundException {
        try {
            String projectId = this.getProjectId(namespace);
            deleteProjectById(getProjectId(namespace));
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }
}