package db;

import models.Competitions.Knockout;
import models.Teams.Team;
import org.hibernate.Session;

public class DBKnockouts {

    private static Session session;

    public static void addTeamTo(Knockout knockout, Team team){
        knockout.addTeam(team);
        DBHelper.update(knockout);
    }

}
