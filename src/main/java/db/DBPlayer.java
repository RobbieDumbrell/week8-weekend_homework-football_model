package db;

import models.Players.Player;
import models.Players.PreferredPosition;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPlayer {

    private static Session session;

    public static ClubTeam getClub(Player player){
        session = HibernateUtil.getSessionFactory().openSession();
        ClubTeam result = null;
        try {
            Criteria cr = session.createCriteria(ClubTeam.class);
            cr.createAlias("squad", "player");
            cr.add(Restrictions.eq("player.id", player.getId()));
            result = (ClubTeam) cr.uniqueResult();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static NationalTeam getNationalTeam(Player player){
        session = HibernateUtil.getSessionFactory().openSession();
        NationalTeam result = null;
        try {
            Criteria cr = session.createCriteria(NationalTeam.class);
            cr.createAlias("nationalPool", "player");
            cr.add(Restrictions.eq("player.id", player.getId()));
            result = (NationalTeam) cr.uniqueResult();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<Player> getPlayersOfPosition(PreferredPosition preferredPosition){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("preferredPosition", preferredPosition));
            results = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
