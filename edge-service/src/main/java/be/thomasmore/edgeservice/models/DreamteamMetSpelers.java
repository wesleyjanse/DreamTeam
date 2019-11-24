package be.thomasmore.edgeservice.models;

import java.util.List;

public class DreamteamMetSpelers {
    private DreamTeam dreamTeam;
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
