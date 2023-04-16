package cl.foxcorp.woff.samplewebflux.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "role")
public class Role {
    @Id
    @Field("_id")
    private String id;
    private String code;
    private String description;
    private boolean valid;
    private LocalDateTime dateCreation;
}