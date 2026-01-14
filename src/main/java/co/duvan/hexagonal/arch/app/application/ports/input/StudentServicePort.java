package co.duvan.hexagonal.arch.app.application.ports.input;

import co.duvan.hexagonal.arch.app.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student findById(Long id);

    List<Student> findAll();

    Student save(Student student);

    Student update(Long id, Student student);

    void deleteByid(Long id);

}
