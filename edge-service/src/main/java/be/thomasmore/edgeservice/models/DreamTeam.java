package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DreamTeam {
    private String id;
    private String naam;
    private Integer userId;
    private List<String> spelersId;

    public DreamTeam(String id, String naam, Integer userId, List<String> spelersId) {
        this.id = id;
        this.userId = userId;
        this.spelersId = spelersId;
        this.naam = naam;
    }

    public DreamTeam() {
    }

    public String getNaam() { return naam; }

    public void setNaam(String naam) { this.naam = naam; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getSpelersId() {
        return spelersId;
    }

    public void setSpelersId(List<String> spelersId) {
        this.spelersId = spelersId;
    }
}
