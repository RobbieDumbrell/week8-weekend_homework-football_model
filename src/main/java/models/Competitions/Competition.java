package models.Competitions;

import models.Teams.Team;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Competition {

    private int id;
    private String name;
    private String sponsor;

    public Competition() {
    }

    public Competition(String name, String sponsor) {
        this.name = name;
        this.sponsor = sponsor;
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

    @Column(name = "sponsor")
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public abstract void addTeam(Team addingTeam);

    public abstract void removeTeam(Team removingTeam);
}
