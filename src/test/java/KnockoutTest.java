import models.Competitions.Knockout;
import models.Competitions.League;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class KnockoutTest {

    League premierLeague;
    League championship;
    Knockout faCup;
    ClubTeam liverpool;
    ClubTeam burnley;
    ClubTeam manUtd;
    Manager klopp;
    Manager dyche;

    @Before
    public void before(){
        premierLeague = new League("Premier League", "Barclay's");
        championship = new League("Championship", "Sky Bet");
        faCup = new Knockout("Premier Knockout", "Barclay's");
        klopp = new Manager("Jurgen Klopp", 48, "4-3-3");
        dyche = new Manager("Sean Dyche", 52, "4-4-2");
        liverpool = new ClubTeam("Liverpool", klopp, premierLeague, 100);
        burnley = new ClubTeam("Burnley", dyche, championship, 50);
        faCup.addTeam(liverpool);
        faCup.addTeam(burnley);

        manUtd = new ClubTeam("Manchester United", klopp, premierLeague, 100);
    }

    @Test
    public void canGenerateGameOutcomes(){
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Win");
        expected.add("Lose");
        assertEquals(expected, faCup.generateGameOutcomes());
    }

    @Test
    public void canSelectAnOutcomeAtRandom(){
        Class classType = faCup.selectRandomOutcome().getClass();
        assertEquals(String.class, classType);
    }

    @Test
    public void knockoutHasTeamsAdded(){
        assertEquals(2, faCup.getRemainingTeams().size());
    }

    @Test
    public void losingGameRemovesLoserFromCompetition(){
        faCup.playGame(liverpool, burnley);
        assertEquals(1, faCup.getRemainingTeams().size());
    }

    @Test
    public void losingGameDoesNotRemoveAnyoneIfBothTeamsNotInCup(){
        faCup.playGame(liverpool, manUtd);
        assertEquals(2, faCup.getRemainingTeams().size());
    }


}
