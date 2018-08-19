package db;

import models.Players.Player;
import models.Teams.ClubTeam;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBClubTeam {

    private static Session session;

    public static void teamBuysPlayer(ClubTeam club, Player player){
        ClubTeam existingClub = DBPlayer.getClub(player);
        club.buyPlayer(player);
        DBHelper.update(existingClub);
        DBHelper.update(player);
        DBHelper.update(club);
    }

    public static List<Player> getPlayers(ClubTeam clubTeam){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("clubTeam", clubTeam));
            results = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
