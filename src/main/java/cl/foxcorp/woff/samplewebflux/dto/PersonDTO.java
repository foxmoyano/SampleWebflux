package cl.foxcorp.woff.samplewebflux.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private String id;
    @NotBlank
    @Size(max = 10)
    private String name;
    private String lastName;
    private LocalDateTime dateCreation;
    private LocalDate dateBirthday;
    private String gender;
}