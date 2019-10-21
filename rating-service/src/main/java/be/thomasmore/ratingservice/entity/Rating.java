package be.thomasmore.ratingservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "rating")
public class Rating {
    @Id
    private String id;
    private Integer userId;
    private Integer movieId;
    private Integer scoreNumber;
}
