package models.Staff;

import models.Teams.Team;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    private int id;
    private String name;
    private int age;
    private String preferredFormation;
    private Team team;

    public Manager() {
    }

    public Manager(String name, int age, String preferredFormation) {
        this.name = name;
        this.age = age;
        this.preferredFormation = preferredFormation;
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

    @Column(name = "preferred_formation")
    public String getPreferredFormation() {
        return preferredFormation;
    }

    public void setPreferredFormation(String preferredFormation) {
        this.preferredFormation = preferredFormation;
    }

    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
