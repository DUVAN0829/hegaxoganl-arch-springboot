package co.duvan.hexagonal.arch.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field fisrtname cannot be empty or null")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be empty or null")
    private String lastname;

    @NotBlank(message = "Field age cannot be null")
    private Integer age;

    @NotBlank(message = "Field address cannot be empty or null")
    private String address;

}
