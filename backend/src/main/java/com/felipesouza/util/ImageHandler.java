package com.felipesouza.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageHandler {

    public static String saveImage(MultipartFile image, String projectName) {
        String imageName = image.getOriginalFilename();
        return saveImage(image, projectName, imageName);
    }


    public static String saveImage(MultipartFile image, String projectName, String imageName) {
        String imagesFolder = String.format("/projects/%s/", projectName);
        String savePath = System.getenv("RESOURCES") + imagesFolder;

        Path filePath = Paths.get( savePath + imageName);

        try {
            Files.createDirectories(filePath.getParent());
            Files.createFile(filePath);
            image.transferTo(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imagesFolder + imageName;
    }
}
