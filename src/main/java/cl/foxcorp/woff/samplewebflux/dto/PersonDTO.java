package cl.foxcorp.woff.samplewebflux.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private String name;
    private String lastName;
    private LocalDate dateCreation;
    private LocalDate dateBirthday;
    private String gender;
}