package co.duvan.hexagonal.arch.app.domain.exception;

public class StudentNotFoundExecption extends RuntimeException {

    public StudentNotFoundExecption(String message) {
        super(message);
    }

}
