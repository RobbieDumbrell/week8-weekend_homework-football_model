package models.Teams;

import models.Competitions.League;
import models.Players.Player;
import models.Staff.Manager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "club_teams")
public class ClubTeam extends Team {

    private List<Player> squad;
    private int transferBudget;

    public ClubTeam() {
    }

    public ClubTeam(String name, Manager manager, League leagueCompetition, int transferBudget) {
        super(name, manager, leagueCompetition);
        this.transferBudget = transferBudget;
        this.squad = new ArrayList<Player>();
    }

    @Column(name = "transfer_budget")
    public int getTransferBudget() {
        return transferBudget;
    }

    public void setTransferBudget(int transferBudget) {
        this.transferBudget = transferBudget;
    }

    @OneToMany(mappedBy = "clubTeam", fetch = FetchType.LAZY)
    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }

    public boolean canBuyPlayer(Player player){
        if (this.transferBudget >= player.getTransferValue()){
            return true;
        }
        return false;
    }

    public void changeTransferBudget(int amount){
        this.transferBudget += amount;
    }

    public void buyPlayer(Player player){
        if (this.canBuyPlayer(player) && player.getClubTeam() != this){
            player.getClubTeam().changeTransferBudget(player.getTransferValue());
            player.setClubTeam(this);
            this.changeTransferBudget((player.getTransferValue() * -1));
        }
    }




}
