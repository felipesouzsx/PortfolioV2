package com.felipesouza.portfolio.asset;

import com.felipesouza.exceptions.AssetNotFoundException;
import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.portfolio.project.ProjectEntity;
import com.felipesouza.portfolio.project.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    private final AssetRepository repository;
    private final ProjectRepository projectRepository;

    public AssetService(AssetRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    private void saveAsset(AssetEntity assetEntity) {
        this.repository.saveAndFlush(assetEntity);
    }

    public AssetEntity addAsset(AssetAddRequest request) throws ProjectNotFoundException {
        ProjectEntity relatedProject = projectRepository.findById(request.project_id())
                .orElseThrow(ProjectNotFoundException::new);

        AssetEntity newAsset = AssetEntity.builder()
                .description(request.description())
                .project(relatedProject)
                .build();
        this.saveAsset(newAsset);

        return newAsset;
    }

    public void updateById(String assetId, AssetAddRequest request) throws AssetNotFoundException, ProjectNotFoundException {
        AssetEntity oldAsset = this.repository.findById(assetId)
                .orElseThrow(AssetNotFoundException::new);

        AssetEntity updatedAsset = AssetEntity.builder()
                .id(assetId)
                .description(request.description() == null ? oldAsset.getDescription() : request.description())
                .project(
                        request.project_id() == null ? oldAsset.getProject()
                        : projectRepository.findById(request.project_id()).orElseThrow(ProjectNotFoundException::new))
                .build();
        saveAsset(updatedAsset);
    }

    public void deleteAsset(String assetId) {
        this.repository.deleteById(assetId);
    }
}
