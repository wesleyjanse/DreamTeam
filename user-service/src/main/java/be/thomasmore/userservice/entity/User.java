package be.thomasmore.userservice.entity;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "user")
public class User {
    @Id
    private Integer userid;
    private String username;
    private String password;

}
