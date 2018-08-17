package models.Teams;

import models.Players.Player;
import models.Staff.Manager;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "national_teams")
public class NationalTeam extends Team {

    private List<Player> nationalPool;

    public NationalTeam() {
    }

    public NationalTeam(String name, Manager manager) {
        super(name, manager);
        this.nationalPool = new ArrayList<Player>();
    }

    @OneToMany(mappedBy = "nationalEligibility", fetch = FetchType.LAZY)
    public List<Player> getNationalPool() {
        return nationalPool;
    }

    public void setNationalPool(List<Player> nationalPool) {
        this.nationalPool = nationalPool;
    }
}
