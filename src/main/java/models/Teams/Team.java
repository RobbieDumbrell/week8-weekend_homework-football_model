package models.Teams;

import models.Players.Player;
import models.Staff.Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Team {

    private int id;
    private String name;
    private Manager manager;
    private List<Player> squad;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
        this.squad = new ArrayList<Player>();
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }
}
