package db;

import models.Players.Player;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBNationalTeam {

    private static Session session;

    public static List<Player> getPlayers(NationalTeam nationalTeam){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("nationalEligibility", nationalTeam));
            results = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
