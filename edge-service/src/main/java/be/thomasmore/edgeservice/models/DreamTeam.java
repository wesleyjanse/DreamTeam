package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DreamTeam {
    private String id;
    private String naam;
    private String userId;
    private List<String> spelersId;

    public DreamTeam(String id, String naam, String userId, List<String> spelersId) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSpelersId() {
        return spelersId;
    }

    public void setSpelersId(List<String> spelersId) {
        this.spelersId = spelersId;
    }
}
