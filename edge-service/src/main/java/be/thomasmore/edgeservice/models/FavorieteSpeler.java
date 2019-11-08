package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavorieteSpeler {
    private String id;
    private String naam;
    private Integer spelerId;
    private Integer teamId;
    private Integer userId;

    public FavorieteSpeler() {
    }

    public FavorieteSpeler(String id, String naam, Integer spelerId, Integer teamId, Integer userId) {
        this.id = id;
        this.naam = naam;
        this.spelerId = spelerId;
        this.teamId = teamId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getSpelerId() {
        return spelerId;
    }

    public void setSpelerId(Integer spelerId) {
        this.spelerId = spelerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}