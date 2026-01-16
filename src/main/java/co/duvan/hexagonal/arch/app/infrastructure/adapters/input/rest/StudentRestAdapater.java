package co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest;

import co.duvan.hexagonal.arch.app.application.ports.input.StudentServicePort;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestAdapater {

    private final StudentServicePort servicePort;
    private final StudentRestMapper mapper;

    //* Handler Methods
    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {
        return this.mapper.listStudentResponse(this.servicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return this.mapper.studentResponse(this.servicePort.findById(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.studentResponse(servicePort.save(mapper.toStudent(studentRequest))));
    }

    @PutMapping("/v1/api/{id}")
    public StudentResponse update(@Valid @PathVariable Long id, @RequestBody StudentCreateRequest studentRequest) {
        return mapper.studentResponse(servicePort.update(id, mapper.toStudent(studentRequest)));
    }

    @DeleteMapping("/v1/api/{id}")
    public void deleteById(@PathVariable Long id) {
        servicePort.deleteByid(id);
    }

}
