package com.felipesouza.portfolio.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="assets")


public class Asset {
    @Id
    private String id;

    @Column(name = "pathToAsset", nullable = false)
    private String pathToAsset;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private String projectId;
}
