package models.Competitions;

import models.Teams.Team;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public ArrayList<String> generateGameOutcomes(){
        ArrayList<String> outcomes = new ArrayList<String>();
        outcomes.add("Win");
        outcomes.add("Lose");
        outcomes.add("Draw");
        return outcomes;
    }

    public String selectRandomOutcome(){
        ArrayList<String> Outcomes = this.generateGameOutcomes();
        Random randomizer = new Random();
        String randomOutcome = Outcomes.get(randomizer.nextInt(Outcomes.size()));
        return randomOutcome;
    }

    public void playGame(Team team1 ,Team team2) {
        String team1Outcome = this.selectRandomOutcome();
        if (team1Outcome.equals("Win")) {
            team1.addLeaguePoints(3);
        }
        if (team1Outcome.equals("Lose")) {
            team2.addLeaguePoints(3);
        }
        if (team1Outcome.equals("Draw")) {
            team1.addLeaguePoints(1);
            team2.addLeaguePoints(1);
        }
    }
    
}
