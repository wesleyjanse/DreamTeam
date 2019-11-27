package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import reactor.util.annotation.Nullable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description="Alle details over de favoriete speler")
public class FavorieteSpeler {
    @ApiModelProperty(notes="Het id van de favoriete speler, gegenereerd door Mongo")
    private String id;
    @ApiModelProperty(notes="De naam van de favoriete speler")
    private String naam;
    @ApiModelProperty(notes="Het userId van de user waaraan de favoriete speler verbonden is")
    private Integer userId;
    @ApiModelProperty(notes="De positie van de favoriete speler op het voetbal veld")
    private String positie;
    @ApiModelProperty(notes="Een afbeelding van de favoriete speler")
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
