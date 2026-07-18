package com.felipesouza.portfolio.testimonials;

import com.felipesouza.exceptions.TestimonialNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialService {
    private final TestimonialRepository repository;
    private final TestimonialDTOMapper mapper;

    public TestimonialService(TestimonialRepository repository, TestimonialDTOMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveTestimonial(TestimonialEntity entity) {
        this.repository.saveAndFlush(entity);
    }

    public void addTestimonial(TestimonialAddRequest request) {
        TestimonialEntity newTestimonial = TestimonialEntity.builder()
                .id(request.id())
                .message(request.message())
                .author(request.author())
                .role(request.role())
                .company(request.company())
                .build();
        this.saveTestimonial(newTestimonial);
    }

    public List<TestimonialDTO> getTestimonials() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper)
                .collect(Collectors.toList());
    }

    public TestimonialDTO getTestimonial(String id) throws TestimonialNotFoundException {
        TestimonialEntity result = this.repository.findById(id)
                .orElseThrow(TestimonialNotFoundException::new);
        return this.mapper.apply(result);
    }

    public void updateTestimonial(String id, TestimonialUpdateRequest newData) throws TestimonialNotFoundException {
        try {
            TestimonialDTO oldData = this.getTestimonial(id);
            TestimonialEntity newEntity = TestimonialEntity.builder()
                    .id(id)
                    .author(newData.author() == null ? oldData.author() : newData.author())
                    .role(newData.role() == null ? oldData.role() : newData.role())
                    .company(newData.company() == null ? oldData.company() : newData.company())
                    .message(newData.message() == null ? oldData.message() : newData.message())
                    .build();
            this.saveTestimonial(newEntity);
        } catch (TestimonialNotFoundException e) {
            throw new TestimonialNotFoundException();
        }
    }

    public void deleteTestimonial(String id) {
        this.repository.deleteById(id);
    }
}
