package models.Teams;

import models.Players.Player;
import models.Staff.Manager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubs")
public class ClubTeam extends Team {

    private List<Player> squad;
    private int transferBudget;

    public ClubTeam() {
    }

    public ClubTeam(String name, Manager manager, int transferBudget) {
        super(name, manager);
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
}
