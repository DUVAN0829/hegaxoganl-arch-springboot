package co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence;

import co.duvan.hexagonal.arch.app.application.ports.output.StudentPersistencePort;
import co.duvan.hexagonal.arch.app.domain.model.Student;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentPersistenceAdapter implements StudentPersistencePort {

    //* Vars
    private final StudentRepository repository;
    private final StudentPersistenceMapper mapper;

    //* Methods
    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void deleteByid(Long id) {

    }

}
