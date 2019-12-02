package be.thomasmore.edgeservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description="Dreamteam helper model om de spelers met users op te vragen")
public class DreamteamsMetSpelersMetUsers {
    @ApiModelProperty(notes="Het dreateam object, waarvoor we de spelers willen opvragen en user willen opvragen")
    private DreamTeam dreamTeam;
    @ApiModelProperty(notes="De lijst van spelers die bij het dreamteam horen")
    private List<FavorieteSpeler> spelers;
    @ApiModelProperty(notes="De user die bij het dreamteam hoort")
    private AppUser user;

    public DreamteamsMetSpelersMetUsers(DreamTeam dreamTeam, List<FavorieteSpeler> spelers, AppUser user) {
        this.dreamTeam = dreamTeam;
        this.spelers = spelers;
        this.user = user;
    }

    public AppUser getUser() { return user; }

    public void setUser(AppUser user) { this.user = user; }

    public DreamTeam getDreamTeam() {
        return dreamTeam;
    }

    public void setDreamTeam(DreamTeam dreamTeam) {
        this.dreamTeam = dreamTeam;
    }

    public List<FavorieteSpeler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<FavorieteSpeler> spelers) {
        this.spelers = spelers;
    }
}
