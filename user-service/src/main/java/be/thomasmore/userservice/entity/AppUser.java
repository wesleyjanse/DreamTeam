package be.thomasmore.userservice.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "appUser")
public class AppUser {
    @Id
    ObjectId databaseId;
    private Integer id;
    private String username, password, role;
}
