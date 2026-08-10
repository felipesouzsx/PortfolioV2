package com.felipesouza.portfolio.project;


import com.felipesouza.exceptions.InvalidUuidException;
import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.util.DateHandler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class ProjectService {
    private final ProjectRepository repository;
    private final ProjectDTOMapper dtoMapper;
    private static final Pattern UUID_V4_REGEX = Pattern.compile(
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$"
    );

    public ProjectService(ProjectRepository repository, ProjectDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    private void saveProject(ProjectEntity projectEntity) {
        this.repository.saveAndFlush(projectEntity);
    }

    public void addProject(ProjectAddRequest request) {
        ProjectEntity newProject = this.getProjectFromRequest(request);
        saveProject(newProject);
    }

    /**
     * Gets the ProjectEntity with the given ID.
     * @param projectId The ProjectEntity's ID (UUIDv4).
     * @return The DTO of the ProjectEntity.
     * @throws ProjectNotFoundException When the ID doesn't belong to any ProjectEntity.
     */
    public ProjectDTO getProjectById(String projectId) throws ProjectNotFoundException, InvalidUuidException {
        if (isUUIDInvalid(projectId)) {
            throw new InvalidUuidException();
        }

        ProjectEntity project = this.repository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("ID not found"));
        return dtoMapper.apply(project);
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


    /**
     * Deletes the ProjectEntity with given ID.
     * @param projectId The ProjectEntity's ID (UUIDv4).
     */
    public void deleteProjectById(String projectId) {
        if (isUUIDInvalid(projectId)) {
            throw new InvalidUuidException();
        }
        this.repository.deleteById(projectId);
    }


    /**
     * Updates the ProjectEntity with the given ID.
     * @param projectId The ProjectEntity's ID (UUIDv4).
     * @param request The request with the values to be edited.
     * @throws ProjectNotFoundException When the ID doesn't belong to any ProjectEntity.
     */
    public void updateProjectById(String projectId, ProjectAddRequest request) throws ProjectNotFoundException  {
        if (isUUIDInvalid(projectId)) {
            throw new InvalidUuidException();
        }

        try {
            ProjectDTO oldDTO = this.getProjectById(projectId);

            Date releaseDate = oldDTO.releaseDate();
            if (request.releaseDate() != null) {
                releaseDate = DateHandler.fromString(request.releaseDate());
            }

            ProjectEntity updatedProjectEntity = ProjectEntity.builder()
                    .id(projectId)
                    .name(request.name() == null ? oldDTO.name() : request.name())
                    .description(request.description() == null ? oldDTO.description() : request.description())
                    .publisher(request.publisher() == null ? oldDTO.publisher() : request.publisher())
                    .releaseDate(releaseDate)
                    .roles(request.roles() == null ? oldDTO.roles() : request.roles())
                    .build();
            this.saveProject(updatedProjectEntity);
        } catch (ProjectNotFoundException e) {
            throw new ProjectNotFoundException(e.getMessage(), e.getCause());
        }
    }

    private ProjectEntity getProjectFromRequest(ProjectAddRequest request) {
        Date convertedDate = DateHandler.fromString(request.releaseDate());
        return ProjectEntity.builder()
                .name(request.name())
                .description(request.description())
                .publisher(request.publisher())
                .releaseDate(convertedDate)
                .roles(request.roles())
                .build();
    }

    private boolean isUUIDInvalid(String uuid) {
        if (uuid == null) {
            return true;
        }
        return !UUID_V4_REGEX.matcher(uuid).matches();
    }
}