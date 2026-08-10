package com.felipesouza.portfolio.project;

import com.felipesouza.portfolio.asset.AssetDTO;
import com.felipesouza.portfolio.asset.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ProjectDTOMapper implements Function<ProjectEntity, ProjectDTO> {
    private final AssetRepository assetRepository;

    public ProjectDTOMapper(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public ProjectDTO apply(ProjectEntity project) {
        List<AssetDTO> assets = assetRepository.findByProjectId(project.getId());

        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getPublisher(),
                project.getReleaseDate(),
                project.getRoles(),
                assets
        );
    }
}
