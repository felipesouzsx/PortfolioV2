package com.felipesouza.portfolio.asset;

import com.felipesouza.exceptions.AssetNotFoundException;
import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.portfolio.media.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5500"})
public class AssetController {

    private final AssetService service;
    private final MediaService mediaService;

    @PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> create(@ModelAttribute AssetAddRequest request) {
        try {
            AssetEntity newAsset = service.addAsset(request);
            mediaService.uploadFile(request.asset_img(), newAsset.getProject().getName(), newAsset.getId());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(params = "id")
    public ResponseEntity<Void> update(@RequestParam String id, @RequestBody AssetAddRequest request) {
        try {
            service.updateById(id, request);
            return ResponseEntity.ok().build();
        } catch (ProjectNotFoundException | AssetNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> delete(@RequestParam String id) {
        service.deleteAsset(id);
        return ResponseEntity.ok().build();
    }
}
