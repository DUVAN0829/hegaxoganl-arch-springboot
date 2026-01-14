package co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.mapper;

import co.duvan.hexagonal.arch.app.domain.model.Student;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    Student toStudent(StudentCreateRequest studentRequest);

    StudentResponse studentResponse(Student student);

    List<StudentResponse> listStudentResponse(List<Student> studentList);

}
