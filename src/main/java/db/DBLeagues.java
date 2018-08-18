package db;

import models.Competitions.League;
import models.Teams.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLeagues {

    private static Session session;

    public static List<Team> getLeagueStandings(League league){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> results = null;
        try {
            Criteria cr = session.createCriteria(Team.class);
            cr.add(Restrictions.eq("leagueCompetition", league));
            cr.addOrder(Order.desc("leaguePoints"));
            results = cr.list();
        } catch(HibernateException e) {
          e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
