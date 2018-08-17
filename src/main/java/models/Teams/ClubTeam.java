package models.Teams;

import models.Players.Player;

import java.util.ArrayList;

public class ClubTeam extends Team {

    private int transferBudget;

    public ClubTeam() {
    }

    public ClubTeam(String name, int transferBudget) {
        super(name);
        this.transferBudget = transferBudget;
        this.squad = new ArrayList<Player>();
    }

    public int getTransferBudget() {
        return transferBudget;
    }

    public void setTransferBudget(int transferBudget) {
        this.transferBudget = transferBudget;
    }
}
