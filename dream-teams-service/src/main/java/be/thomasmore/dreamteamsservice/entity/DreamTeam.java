package be.thomasmore.dreamteamsservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.List;

@Data
@Document(collection = "dreamTeam")
public class DreamTeam {
    @Id
    private String id;
    private String naam;
    private Integer userId;
    private List<Integer> spelersId;
}
