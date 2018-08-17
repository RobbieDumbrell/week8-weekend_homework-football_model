package models.Players;

import models.Teams.ClubTeam;
import models.Teams.NationalTeam;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    private int id;
    private String name;
    private int age;
    private int transferValue;
    private ClubTeam clubTeam;
    private NationalTeam nationalEligibility;

    public Player() {
    }

    public Player(String name, int age, int transferValue, ClubTeam clubTeam, NationalTeam nationalEligibility) {
        this.name = name;
        this.age = age;
        this.transferValue = transferValue;
        this.clubTeam = clubTeam;
        this.nationalEligibility = nationalEligibility;
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

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "transfer_value")
    public int getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(int transferValue) {
        this.transferValue = transferValue;
    }

    @ManyToOne
    @JoinColumn(name = "club_team_id")
    public ClubTeam getClubTeam() {
        return clubTeam;
    }

    public void setClubTeam(ClubTeam clubTeam) {
        this.clubTeam = clubTeam;
    }

    @ManyToOne
    @JoinColumn(name = "national_team_id")
    public NationalTeam getNationalEligibility() {
        return nationalEligibility;
    }

    public void setNationalEligibility(NationalTeam nationalEligibility) {
        this.nationalEligibility = nationalEligibility;
    }
}
