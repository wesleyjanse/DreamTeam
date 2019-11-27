package be.thomasmore.edgeservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description="Dreamteam helper model om de spelers op te vragen")
public class DreamteamMetSpelers {
    @ApiModelProperty(notes="Het dreateam object, waarvoor we de spelers willen opvragen")
    private DreamTeam dreamTeam;
    @ApiModelProperty(notes="De lijst van spelers die bij het dreamteam horen")
    private List<FavorieteSpeler> spelers;

    public DreamteamMetSpelers(DreamTeam dreamTeam, List<FavorieteSpeler> spelers) {
        this.dreamTeam = dreamTeam;
        this.spelers = spelers;
    }

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
