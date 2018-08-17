package models.Players;

import models.Teams.ClubTeam;
import models.Teams.NationalTeam;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(int transferValue) {
        this.transferValue = transferValue;
    }

    public ClubTeam getClubTeam() {
        return clubTeam;
    }

    public void setClubTeam(ClubTeam clubTeam) {
        this.clubTeam = clubTeam;
    }

    public NationalTeam getNationalEligibility() {
        return nationalEligibility;
    }

    public void setNationalEligibility(NationalTeam nationalEligibility) {
        this.nationalEligibility = nationalEligibility;
    }
}
