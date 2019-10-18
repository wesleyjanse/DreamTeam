package be.thomasmore.genreservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "genre")
public class Genre {
    @Id
    private String id;
    private Integer userId;
    private Integer movieId;
    private Integer name;
}
