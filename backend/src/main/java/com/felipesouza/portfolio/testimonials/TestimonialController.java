package com.felipesouza.portfolio.testimonials;


import com.felipesouza.exceptions.MediaException;
import com.felipesouza.exceptions.TestimonialNotFoundException;
import com.felipesouza.portfolio.media.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testimonials")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5500"})
@Slf4j
public class TestimonialController {
    private final TestimonialService service;
    private final MediaService media;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createTestimonial(@ModelAttribute TestimonialAddRequest request) {
        try {
            service.addTestimonial(request);
            media.uploadFile(request.picture(), "testimonials", request.author());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (MediaException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.unprocessableContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TestimonialDTO>> getAllTestimonials() {
        log.info("Boo!");
        return ResponseEntity.ok(service.getTestimonials());
    }

    @GetMapping(params = "id")
    public ResponseEntity<TestimonialDTO> getTestimonial(@RequestParam String id) {
        log.info(id);
        if (isIdInvalid(id)) return ResponseEntity.badRequest().build();
        try {
            return ResponseEntity.ok(service.getTestimonial(id));
        } catch (TestimonialNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(params = "id")
    public ResponseEntity<Void> updateTestimonial(@RequestParam String id, @RequestBody TestimonialUpdateRequest newData) {
        log.info(id);
        if (isIdInvalid(id)) return ResponseEntity.badRequest().build();
        try {
            service.updateTestimonial(id, newData);
            return ResponseEntity.ok().build();
        } catch (TestimonialNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deleteTestimonial(@RequestParam String id) {
        if (isIdInvalid(id)) return ResponseEntity.badRequest().build();

        service.deleteTestimonial(id);
        return ResponseEntity.ok().build();
    }

    private boolean isIdInvalid(String namespace) {
        int NAMESPACE_LEN = 8;
        return namespace.length() > NAMESPACE_LEN || namespace.isEmpty();
    }
}
