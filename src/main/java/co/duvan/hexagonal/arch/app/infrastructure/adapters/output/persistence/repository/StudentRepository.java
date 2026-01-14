package co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.repository;

import co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
