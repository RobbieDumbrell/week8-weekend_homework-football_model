import models.Competitions.League;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class LeagueTest {

    League premierLeague;
    League championship;
    ClubTeam liverpool;
    ClubTeam burnley;
    Manager klopp;
    Manager dyche;

    @Before
    public void before(){
        premierLeague = new League("Premier League", "Barclay's");
        championship = new League("Championship", "Sky Bet");
        klopp = new Manager("Jurgen Klopp", 48, "4-3-3");
        dyche = new Manager("Sean Dyche", 52, "4-4-2");
        liverpool = new ClubTeam("Liverpool", klopp, premierLeague, 100);
        burnley = new ClubTeam("Burnley", dyche, premierLeague, 50);

    }

    @Test
    public void canGenerateGameOutcomes(){
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Win");
        expected.add("Lose");
        expected.add("Draw");
        assertEquals(expected, premierLeague.generateGameOutcomes());
    }

    @Test
    public void canSelectAnOutcomeAtRandom(){
        Class classType = premierLeague.selectRandomOutcome().getClass();
        assertEquals(String.class, classType);
    }

    @Test
    public void canAssignPointsBasedOnOutcome(){
        int totalPoints = (liverpool.getLeaguePoints() + burnley.getLeaguePoints());
        assertEquals(0, totalPoints);
        premierLeague.playGame(liverpool, burnley);
        int newTotalPoints = (liverpool.getLeaguePoints() + burnley.getLeaguePoints());
        assertEquals(true, newTotalPoints >= 2);
    }

    @Test
    public void noPointsAssignedIfBothTeamsAreNotInLeague(){
        int totalPoints = (liverpool.getLeaguePoints() + burnley.getLeaguePoints());
        assertEquals(0, totalPoints);
        championship.playGame(liverpool, burnley);
        int newTotalPoints = (liverpool.getLeaguePoints() + burnley.getLeaguePoints());
        assertEquals(false, newTotalPoints >= 2);
    }

}
