package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import reactor.util.annotation.Nullable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavorieteSpeler {
    private String id;
    private String naam;
    private Integer userId;
    private String positie;
    private String afbeelding;

    public FavorieteSpeler() {
    }

    public FavorieteSpeler(String id, String naam, Integer userId, String positie, String afbeelding) {
        this.id = id;
        this.naam = naam;
        this.userId = userId;
        this.positie = positie;
        this.afbeelding = afbeelding;
    }

    public String getAfbeelding() { return afbeelding; }

    public void setAfbeelding(String afbeelding) { this.afbeelding = afbeelding; }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPositie() {
        return positie;
    }

    public void setPositie(String positie) {
        this.positie = positie;
    }
}
