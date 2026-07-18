package com.felipesouza.portfolio.media;

import com.felipesouza.exceptions.FileUploadException;
import com.felipesouza.exceptions.UnsupportedMediaTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final S3Client s3Client;

    @Value("${cloudflare.r2.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile file, String folder) throws UnsupportedMediaTypeException, FileUploadException {
        String ogFileName = Optional.ofNullable(file.getOriginalFilename())
                .orElseThrow(() -> new UnsupportedMediaTypeException("Filename is missing"))
                .toLowerCase();
        return uploadFile(file, folder, ogFileName);
    }


    public String uploadFile(MultipartFile file, String folder, String fileName) throws UnsupportedMediaTypeException, FileUploadException {
        String contentType = Optional.ofNullable(file.getContentType())
                .orElseThrow(() -> new UnsupportedMediaTypeException("Content-Type is unknown"));

        String key = String.format("%s/%s", folder, fileName);

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(contentType)
                .build();

        try {
            s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
        } catch (IOException e) {
            throw new FileUploadException("File upload to Cloudflare R2 failed");
        }

        return key;
    }
}
