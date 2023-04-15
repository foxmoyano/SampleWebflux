package cl.foxcorp.woff.samplewebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "person")
public class Person {
    private String name;
    private String lastName;
    private LocalDate dateCreation;
    private LocalDate dateBirthday;
    private String gender;
}
