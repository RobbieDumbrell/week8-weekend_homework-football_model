package models.Teams;

import models.Staff.Manager;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Team {

    private int id;
    private String name;
    private Manager manager;

    public Team() {
    }

    public Team(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
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
}
