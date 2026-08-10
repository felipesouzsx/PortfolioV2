package com.felipesouza.portfolio.asset;


import com.felipesouza.portfolio.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="assets")
@Entity
@Builder

public class AssetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="project_id")
    private ProjectEntity project;
}
