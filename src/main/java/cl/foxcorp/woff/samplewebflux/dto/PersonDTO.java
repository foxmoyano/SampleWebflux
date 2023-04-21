package cl.foxcorp.woff.samplewebflux.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JsonUnwrapped
    private List<RoleDTO> roles = new ArrayList<>();
    @JsonUnwrapped
    private List<CommentDTO> comments = new ArrayList<>();
}