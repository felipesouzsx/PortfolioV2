package com.felipesouza.portfolio.project;


import com.felipesouza.exceptions.InvalidUuidException;
import com.felipesouza.exceptions.MediaException;
import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.portfolio.media.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5500"})
public class ProjectController {
    private final ProjectService service;
    private final MediaService mediaService;


    @PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> postProject(@ModelAttribute ProjectAddRequest request) {
        try {
            service.addProject(request);
            mediaService.uploadFile(request.logoImage(), request.name(), "logo.png");
            mediaService.uploadFile(request.heroImage(), request.name(), "hero.png");
        } catch (MediaException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.unprocessableContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(service.getProjects());
    }

    @GetMapping(params = "id")
    public ResponseEntity<ProjectDTO> getProject(@RequestParam String id) {
        try {
            ProjectDTO project = service.getProjectById(id);
            return ResponseEntity.ok(project);
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (InvalidUuidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(params = "id")
    public ResponseEntity<Void> updateProject(@RequestParam String id, @RequestBody ProjectAddRequest newProject) {
        try {
            service.updateProjectById(id, newProject);
            return ResponseEntity.ok().build();
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (InvalidUuidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteProject(@RequestParam String id) {
        service.deleteProjectById(id);
        return ResponseEntity.ok().build();
    }
}
