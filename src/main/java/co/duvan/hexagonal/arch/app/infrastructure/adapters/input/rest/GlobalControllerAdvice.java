package co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest;

import co.duvan.hexagonal.arch.app.domain.exception.StudentNotFoundExecption;
import co.duvan.hexagonal.arch.app.domain.model.ErrorResponse;
import co.duvan.hexagonal.arch.app.utils.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class GlobalControllerAdvice {

    //* Not found Exception
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundExecption.class)
    public ErrorResponse handlerStudentNotFoundException() {

        return ErrorResponse.builder()
                .code(ErrorCatalog.STUDENT_NOT_FOUND.getCode())
                .message(ErrorCatalog.STUDENT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    //* Method Argument Not Valid Exception
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(ErrorCatalog.STUDENT_NOT_FOUND.getCode())
                .message(ErrorCatalog.STUDENT_NOT_FOUND.getMessage())
                .details(result.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                .timestamp(LocalDateTime.now())
                .build();
    }

    //* Generic Exception
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception) {

        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();

    }

}

















