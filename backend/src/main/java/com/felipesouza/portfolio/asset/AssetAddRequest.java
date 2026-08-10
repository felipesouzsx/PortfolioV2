package com.felipesouza.portfolio.asset;

import org.springframework.web.multipart.MultipartFile;

public record AssetAddRequest(
        String project_id,
        MultipartFile asset_img,
        String description
) {
}
