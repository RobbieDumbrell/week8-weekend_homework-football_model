package models.Teams;

import models.Players.Player;

import java.util.ArrayList;

public class NationalTeam extends Team {

    public NationalTeam() {
    }

    public NationalTeam(String name) {
        super(name);
        this.squad = new ArrayList<Player>();
    }
}
