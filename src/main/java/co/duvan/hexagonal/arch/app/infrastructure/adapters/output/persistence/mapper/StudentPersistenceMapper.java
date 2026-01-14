package co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.mapper;

import co.duvan.hexagonal.arch.app.domain.model.Student;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity studentEntity);

    List<Student> toListStudent (List<StudentEntity> listStudentEntity);

}
