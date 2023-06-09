package cl.foxcorp.woff.samplewebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "person")
public class Person {
    @Id
    @Field("id")
    private String id;
    private String name;
    private String lastName;
    private LocalDateTime dateCreation;
    private LocalDate dateBirthday;
    private String gender;
    @DBRef
    private List<Role> roles = new ArrayList<>();
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}