package com.felipesouza.portfolio.project;


import com.felipesouza.exceptions.ProjectNotFoundException;
import com.felipesouza.util.ImageHandler;
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


    @PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> postProject(@ModelAttribute ProjectAddRequest request) {
        ImageHandler.saveImage(request.logoImage(), request.name(), "logo.png");
        ImageHandler.saveImage(request.heroImage(), request.name(), "hero.png");
        service.addProject(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<ProjectDTO>> getProject() {
        return ResponseEntity.ok(service.getProjects());
    }

    @GetMapping(params = "namespace")
    public ResponseEntity<ProjectDTO> getOneProject(@RequestParam String namespace) {
        if (isNamespaceInvalid(namespace)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ProjectDTO project = service.getProjectByNamespace(namespace);
            return ResponseEntity.ok(project);
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<Void> updateProject(@RequestParam String namespace, @RequestBody ProjectAddRequest newProject) {
        if (isNamespaceInvalid(namespace)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            service.updateProjectByNamespace(namespace, newProject);
            return ResponseEntity.ok().build();
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteProject(@RequestParam String namespace) {
        if (isNamespaceInvalid(namespace)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            service.deleteProjectByNamespace(namespace);
            return ResponseEntity.ok().build();
        } catch (ProjectNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }


    private boolean isNamespaceInvalid(String namespace) {
        int NAMESPACE_LEN = 8;
        return namespace.length() > NAMESPACE_LEN || namespace.isEmpty();
    }
}
