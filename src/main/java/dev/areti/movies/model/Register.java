package dev.areti.movies.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Register {
    @Id
    private ObjectId id;
    private String email;
    private String name;
    private String password;
    private long phoneNumber;

}
