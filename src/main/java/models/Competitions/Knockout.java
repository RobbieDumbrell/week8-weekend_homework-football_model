package models.Competitions;

import models.Teams.Team;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "knockouts")
public class Knockout extends Competition {

    private List<Team> remainingTeams;

    public Knockout() {
    }

    public Knockout(String name, String sponsor) {
        super(name, sponsor);
        this.remainingTeams = new ArrayList<Team>();
    }

    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(
            name = "knockouts_teams",
            joinColumns = {@JoinColumn(name = "knockout_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    public List<Team> getRemainingTeams() {
        return remainingTeams;
    }

    public void setRemainingTeams(List<Team> remainingTeams) {
        this.remainingTeams = remainingTeams;
    }

    @Override
    public void addTeam(Team addingTeam){
        this.remainingTeams.add(addingTeam);
    }

    @Override
    public void removeTeam(Team removingTeam) {
        this.remainingTeams.remove(removingTeam);
    }

    public ArrayList<String> generateGameOutcomes(){
        ArrayList<String> outcomes = new ArrayList<String>();
        outcomes.add("Win");
        outcomes.add("Lose");
        return outcomes;
    }

    public String selectRandomOutcome(){
        ArrayList<String> Outcomes = this.generateGameOutcomes();
        Random randomizer = new Random();
        String randomOutcome = Outcomes.get(randomizer.nextInt(Outcomes.size()));
        return randomOutcome;
    }

    public void playGame(Team team1 ,Team team2) {
        if (this.remainingTeams.contains(team1) && this.remainingTeams.contains(team2)){

            String team1Outcome = this.selectRandomOutcome();
            if (team1Outcome.equals("Win")) {
                removeTeam(team2);
            }
            if (team1Outcome.equals("Lose")) {
                removeTeam(team1);
            }
        }
    }
}
