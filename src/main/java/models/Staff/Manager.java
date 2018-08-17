package models.Staff;

import models.Teams.Team;

public class Manager {

    private int id;
    private String name;
    private int age;
    private String preferredFormation;
    private Team team;

    public Manager() {
    }

    public Manager(String name, int age, String preferredFormation, Team team) {
        this.name = name;
        this.age = age;
        this.preferredFormation = preferredFormation;
        this.team = team;
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

    public String getPreferredFormation() {
        return preferredFormation;
    }

    public void setPreferredFormation(String preferredFormation) {
        this.preferredFormation = preferredFormation;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
