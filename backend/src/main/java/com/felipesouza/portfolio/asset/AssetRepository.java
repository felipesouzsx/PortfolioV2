package com.felipesouza.portfolio.asset;

import com.felipesouza.portfolio.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<AssetEntity, String> {
    List<AssetDTO> findByProject(ProjectEntity project);
    List<AssetDTO> findByProjectId(String projectId);
    @Query("""
        SELECT asset.id
        FROM AssetEntity asset
        WHERE asset.project.id = :projectId
    """)
    List<String> findIdsByProjectId(String projectId);
}
