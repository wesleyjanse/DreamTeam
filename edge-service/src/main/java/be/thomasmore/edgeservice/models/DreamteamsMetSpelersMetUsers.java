package be.thomasmore.edgeservice.models;

import java.util.List;

public class DreamteamsMetSpelersMetUsers {

    private DreamTeam dreamTeam;
    private List<FavorieteSpeler> spelers;
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
