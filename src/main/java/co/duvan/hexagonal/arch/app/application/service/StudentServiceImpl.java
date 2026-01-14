package co.duvan.hexagonal.arch.app.application.service;

import co.duvan.hexagonal.arch.app.application.ports.input.StudentServicePort;
import co.duvan.hexagonal.arch.app.application.ports.output.StudentPersistencePort;
import co.duvan.hexagonal.arch.app.domain.exception.StudentNotFoundExecption;
import co.duvan.hexagonal.arch.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServicePort {

    //* Vars
    private final StudentPersistencePort persistencePort;

    //* Methods
    @Override
    public Student findById(Long id) {
        return this.persistencePort.findById(id)
                .orElseThrow(() -> new StudentNotFoundExecption("User not found"));
    }

    @Override
    public List<Student> findAll() {
        return this.persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return this.persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return this.persistencePort.findById(id)
                .map(stud -> {
                    stud.setFirstname(student.getFirstname());
                    stud.setLastname(student.getLastname());
                    stud.setAge(student.getAge());
                    stud.setAddress(student.getAddress());
                    return this.persistencePort.save(stud);
                }).orElseThrow(() -> new StudentNotFoundExecption("User not found"));
    }

    @Override
    public void deleteByid(Long id) {

        if(this.persistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundExecption("user not found");
        }

       this.persistencePort.deleteByid(id);

    }

}
