import models.Competitions.League;
import models.Players.Player;
import models.Players.PreferredPosition;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClubTeamTest {
    ClubTeam liverpool;
    ClubTeam manUtd;
    NationalTeam france;
    NationalTeam england;
    Manager klopp;
    Manager mourinho;
    League premierLeague;
    Player pogba;
    Player rashford;

    @Before
    public void before(){
        klopp = new Manager("Jurgen Klopp", 48, "4-3-3");
        mourinho = new Manager("Jose Mourinho", 52, "4-4-2");
        premierLeague = new League("Premier League", "Barclay's");
        liverpool = new ClubTeam("Liverpool", klopp, premierLeague, 100);
        manUtd = new ClubTeam("Manchester United", mourinho, premierLeague, 150);
        france = new NationalTeam("France", klopp, premierLeague);
        england = new NationalTeam("England", mourinho, premierLeague);
        pogba = new Player("Paul Pogba", 23, PreferredPosition.MIDFIELDER, 100, manUtd, france);
        rashford = new Player("Marcus Rashford", 21, PreferredPosition.FORWARD, 101, manUtd, england);
    }

    @Test
    public void clubHasEnoughBudget__True(){
        assertEquals(true, liverpool.canBuyPlayer(pogba));
    }

    @Test
    public void clubHasEnoughBudget__False(){
        assertEquals(false, liverpool.canBuyPlayer(rashford));
    }

    @Test
    public void clubCanBuyPlayerAndClubTeamUpdates(){
        assertEquals(100, liverpool.getTransferBudget());
        assertEquals(150, manUtd.getTransferBudget());
        assertEquals(manUtd, pogba.getClubTeam());
        liverpool.buyPlayer(pogba);
        assertEquals(0, liverpool.getTransferBudget());
        assertEquals(250, manUtd.getTransferBudget());
        assertEquals(liverpool, pogba.getClubTeam());
    }

    @Test
    public void clubCanNotBuyOwnPlayer(){
        manUtd.buyPlayer(pogba);
        assertEquals(150, manUtd.getTransferBudget());
        assertEquals(manUtd, pogba.getClubTeam());
    }

}
