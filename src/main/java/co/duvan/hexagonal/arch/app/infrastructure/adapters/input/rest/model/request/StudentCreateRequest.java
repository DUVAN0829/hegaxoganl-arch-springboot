package co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field firstname cannot be blank")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be blank")
    private String lastname;

    @NotNull(message = "Field age cannot be null")
    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age must be realistic")
    private Integer age;

    @NotBlank(message = "Field address cannot be blank")
    private String address;

}
