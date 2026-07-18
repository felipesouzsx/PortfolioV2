package com.felipesouza.portfolio.project;


import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.util.DateHandler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectService {
    private final ProjectRepository repository;
    private final ProjectDTOMapper dtoMapper;

    public ProjectService(ProjectRepository repository, ProjectDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }


    /**
     * Finds a project based on it's namespace and returns it's ID.
     * @param namespace The ProjectEntity's namespace.
     * @return The ProjectEntity's ID (UUIDv4).
     * @throws ProjectNotFoundException When the namespace doesn't belong to any ProjectEntity.
     */
    private String getProjectId(String namespace) throws ProjectNotFoundException {
        ProjectEntity projectEntity = repository.findByNamespace(namespace)
                .orElseThrow(() -> new ProjectNotFoundException("Namespace doesn't belong to any ProjectEntity"));
        return projectEntity.getId();
    }

    /**
     * Gets the ProjectEntity with the given ID.
     * @param projectId The ProjectEntity's ID (UUIDv4).
     * @return The DTO of the ProjectEntity.
     * @throws ProjectNotFoundException When the ID doesn't belong to any ProjectEntity.
     */
    public ProjectDTO getProjectById(String projectId) throws ProjectNotFoundException {
        ProjectEntity project = this.repository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("ID not found"));
        return dtoMapper.apply(project);
    }

    // Pretty self explainatory tbh wont make a doc out of this
    public void saveProject(ProjectEntity projectEntity) {
        this.repository.saveAndFlush(projectEntity);
    }


    public void addProject(ProjectAddRequest request) {
        ProjectEntity newProject = this.getProjectFromRequest(request);
        saveProject(newProject);
    }


    /**
     * @return The DTO's of all Projects.
     */
    public List<ProjectDTO> getProjects() {
        return this.repository.findAll()
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    public List<SimpleProjectDTO> getSimplifiedProjects() {
        return getProjects()
                .stream()
                .map(ProjectDTOMapper::simplify)
                .collect(Collectors.toList());
    }


    /**
     * Deletes the ProjectEntity with given ID.
     * @param projectId The ProjectEntity's ID (UUIDv4).
     */
    public void deleteProjectById(String projectId) {
        this.repository.deleteById(projectId);
    }


    /**
     * Updates the ProjectEntity with the given ID.
     * @param id The ProjectEntity's ID (UUIDv4).
     * @param request The request with the values to be edited.
     * @throws ProjectNotFoundException When the ID doesn't belong to any ProjectEntity.
     */
    public void updateProjectById(String id, ProjectAddRequest request) throws ProjectNotFoundException
    {
        try {
            ProjectDTO oldDTO = this.getProjectById(id);

            Date releaseDate = oldDTO.releaseDate();
            if (request.releaseDate() != null) {
                releaseDate = DateHandler.fromString(request.releaseDate());
            }

            ProjectEntity updatedProjectEntity = ProjectEntity.builder()
                    .id(id)
                    .name(request.name() == null ? oldDTO.name() : request.name())
                    .description(request.description() == null ? oldDTO.description() : request.description())
                    .namespace(request.namespace() == null ? oldDTO.namespace() : request.namespace())
                    .publisher(request.publisher() == null ? oldDTO.publisher() : request.publisher())
                    .releaseDate(releaseDate)
                    .roles(request.roles() == null ? oldDTO.roles() : request.roles())
                    .build();
            this.saveProject(updatedProjectEntity);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }


    /**
     * Returns a ProjectDTO based on the provided namespace
     * @param namespace The namespace of the project.
     * @return The ProjectEntity's {@code ProjectDTO}.
     * @throws ProjectNotFoundException When the namespace doesn't belong to any ProjectEntity.
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
     * Gets the ProjectEntity with the given Namespace.
     * @param namespace The namespace of the project.
     * @return The ProjectEntity's {@code ProjectDTO}.
     * @throws ProjectNotFoundException When the namespace doesn't belong to any ProjectEntity.
     */
    public ProjectDTO getSimpleProjectByNamespace(String namespace) throws ProjectNotFoundException {
        try {
            String projectId = this.getProjectId(namespace);
            return this.getProjectById(projectId);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }


    /**
     * Updates the ProjectEntity with the given Namespace
     * @param namespace The namespace of the project.
     * @param request The request with the values to be edited.
     * @throws ProjectNotFoundException When the namespace doesn't belong to any ProjectEntity.
     */
    public void updateProjectByNamespace(String namespace, ProjectAddRequest request) throws ProjectNotFoundException {
        try {
            String projectId = this.getProjectId(namespace);
            updateProjectById(projectId, request);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }


    /**
     * Deletes the ProjectEntity with the given Namespace.
     * @param namespace The namespace of the ProjectEntity.
     * @throws RuntimeException When the namespace doesn't belong to any ProjectEntity.
     */
    public void deleteProjectByNamespace(String namespace) throws ProjectNotFoundException {
        try {
            deleteProjectById(getProjectId(namespace));
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }


    private ProjectEntity getProjectFromRequest(ProjectAddRequest request) {
        Date convertedDate = DateHandler.fromString(request.releaseDate());
        return ProjectEntity.builder()
                .name(request.name())
                .description(request.description())
                .namespace(request.namespace())
                .publisher(request.publisher())
                .releaseDate(convertedDate)
                .roles(request.roles())
                .build();
    }
}