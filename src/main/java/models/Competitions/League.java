package models.Competitions;

import models.Teams.Team;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League extends Competition{

    private List<Team> teams;

    public League() {
    }

    public League(String name, String sponsor) {
        super(name, sponsor);
        this.teams = new ArrayList<Team>();
    }

    @OneToMany(mappedBy = "leagueCompetition", fetch = FetchType.LAZY)
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public void addTeam(Team addingTeam){
        this.teams.add(addingTeam);
    }

    @Override
    public void removeTeam(Team removingTeam) {
        this.teams.remove(removingTeam);
    }
}
