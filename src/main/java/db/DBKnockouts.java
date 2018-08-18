package db;

import models.Competitions.Knockout;
import models.Teams.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBKnockouts {

    private static Session session;

    public static void addTeamTo(Knockout knockout, Team team) {
        knockout.addTeam(team);
        DBHelper.update(knockout);
    }

    public static List<Team> getTeamsInKnockout(Knockout knockout) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> results = null;
        try {
            Criteria cr = session.createCriteria(Team.class);
            cr.createAlias("knockoutCompetitions", "knockout");
            cr.add(Restrictions.eq("knockout.id", knockout.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
