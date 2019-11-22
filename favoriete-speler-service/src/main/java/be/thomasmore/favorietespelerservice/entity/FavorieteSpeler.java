package be.thomasmore.favorietespelerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Data
@Document(collection = "favorieteSpeler")
public class FavorieteSpeler {
    @Id
    private String id;
    private String naam;
    private Integer spelerId;
    private Integer teamId;
    private Integer userId;
    @Nullable
    private String positie;
}
