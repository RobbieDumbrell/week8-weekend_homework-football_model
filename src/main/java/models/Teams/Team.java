package models.Teams;

import models.Competitions.Knockout;
import models.Competitions.League;
import models.Staff.Manager;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Team {

    private int id;
    private String name;
    private Manager manager;
    private List<Knockout> knockoutCompetitions;
    private League leagueCompetition;
    private int leaguePoints;


    public Team() {
    }

    public Team(String name, Manager manager, League leagueCompetition) {
        this.name = name;
        this.manager = manager;
        this.leagueCompetition = leagueCompetition;
        this.leaguePoints = 0;
        this.knockoutCompetitions = new ArrayList<Knockout>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    public League getLeagueCompetition() {
        return leagueCompetition;
    }

    public void setLeagueCompetition(League leagueCompetition) {
        this.leagueCompetition = leagueCompetition;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(
            name = "knockouts_teams",
            joinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "knockout_id", nullable = false, updatable = false)}
    )
    public List<Knockout> getKnockoutCompetitions() {
        return knockoutCompetitions;
    }

    public void setKnockoutCompetitions(List<Knockout> knockoutCompetitions) {
        this.knockoutCompetitions = knockoutCompetitions;
    }

    @Column(name = "league_points")
    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public void addLeaguePoints(int leaguePoints){
        this.leaguePoints += leaguePoints;
    }
}
