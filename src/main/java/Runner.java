import db.DBHelper;
import db.DBKnockouts;
import models.Competitions.Competition;
import models.Competitions.Knockout;
import models.Competitions.League;
import models.Players.Player;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;
import models.Teams.Team;

import javax.persistence.ManyToMany;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager klopp = new Manager("Jurgen Klopp", 45, "4-3-3");
        Manager mourinho = new Manager("Jose Mourinho", 50, "4-4-2");
        Manager guardiola = new Manager("Josep Guardiola", 42, "4-3-2-1");
        Manager dyche = new Manager("Sean Dyche", 52, "4-4-2");
        Manager southgate = new Manager("Gareth Southgate", 48, "5-3-2");
        Manager martinez = new Manager("Roberto Martinez", 40, "4-4-1-1");
        Manager anEgyptianManager = new Manager("Mr. Egypt", 50, "4-5-1");
        Manager aBrazilianManager = new Manager("Mr. Brazil", 60, "4-2-4");

        DBHelper.save(klopp);
        DBHelper.save(mourinho);
        DBHelper.save(guardiola);
        DBHelper.save(dyche);
        DBHelper.save(southgate);
        DBHelper.save(martinez);
        DBHelper.save(anEgyptianManager);
        DBHelper.save(aBrazilianManager);

        League premierLeague = new League("Premier League", "Barclay's");
        League championship = new League("Championship", "Sky Bet");
        League worldCupQualifier1 =  new League("World Cup Qualifier", "FIFA");

        DBHelper.save(premierLeague);
        DBHelper.save(championship);
        DBHelper.save(worldCupQualifier1);

        NationalTeam england = new NationalTeam("England", southgate, worldCupQualifier1);
        NationalTeam belgium = new NationalTeam("Belgium", martinez, worldCupQualifier1);
        NationalTeam egypt = new NationalTeam("Egypt", anEgyptianManager, worldCupQualifier1);
        NationalTeam brazil = new NationalTeam("Brazil", aBrazilianManager, worldCupQualifier1);

        DBHelper.save(england);
        DBHelper.save(belgium);
        DBHelper.save(egypt);
        DBHelper.save(brazil);

        ClubTeam liverpool = new ClubTeam("Liverpool", klopp, premierLeague, 100);
        ClubTeam manUtd = new ClubTeam("Manchester United", mourinho, premierLeague, 150);
        ClubTeam manCity = new ClubTeam("Manchester City", guardiola, premierLeague, 200);
        ClubTeam burnley = new ClubTeam("Burnley", dyche, premierLeague, 50);

        DBHelper.save(liverpool);
        DBHelper.save(manUtd);
        DBHelper.save(manCity);
        DBHelper.save(burnley);

        Player salah = new Player("Mohamed Salah", 26, 65, liverpool, egypt);
        Player firmino = new Player("Roberto Firmino", 25, 50, liverpool, brazil);
        Player sterling = new Player("Raheem Stirling", 24, 40, manCity, england);
        Player deBruyne = new Player("Kevin De Bruyne", 26, 70, manCity, belgium);
        Player lukaku = new Player("Romelu Lukaku", 25, 55, manUtd, belgium);
        Player jesus = new Player("Gabriel Jesus", 21, 30, manCity, brazil);
        Player rashford = new Player("Marcus Rashford", 20, 35, manUtd, england);
        Player fred = new Player("Fred", 27, 25, manUtd, brazil);
        Player henderson = new Player("Jordan Henderson", 27, 15, liverpool, england);
        Player tarkowski = new Player("James Tarkowski", 24, 5, burnley, england);
        Player mee = new Player("Ben Mee", 28, 10, burnley, england);
        Player cork = new Player("Jack Cork", 29, 5, burnley, england);

        DBHelper.save(salah);
        DBHelper.save(firmino);
        DBHelper.save(sterling);
        DBHelper.save(deBruyne);
        DBHelper.save(lukaku);
        DBHelper.save(jesus);
        DBHelper.save(rashford);
        DBHelper.save(fred);
        DBHelper.save(henderson);
        DBHelper.save(tarkowski);
        DBHelper.save(mee);
        DBHelper.save(cork);

        Knockout faCup = new Knockout("FA Cup", "Emirates");
        Knockout leagueCup = new Knockout("League Cup", "Carabao");
        Knockout worldCup = new Knockout("World Cup", "FIFA");

        DBHelper.save(faCup);
        DBHelper.save(leagueCup);
        DBHelper.save(worldCup);

        DBKnockouts.addTeamto(faCup, liverpool);
        DBKnockouts.addTeamto(faCup, manCity);
        DBKnockouts.addTeamto(faCup, manUtd);
        DBKnockouts.addTeamto(faCup, burnley);
        DBKnockouts.addTeamto(leagueCup, liverpool);
        DBKnockouts.addTeamto(leagueCup, manCity);
        DBKnockouts.addTeamto(leagueCup, manUtd);
        DBKnockouts.addTeamto(leagueCup, burnley);
        DBKnockouts.addTeamto(worldCup, england);
        DBKnockouts.addTeamto(worldCup, belgium);
        DBKnockouts.addTeamto(worldCup, brazil);
        DBKnockouts.addTeamto(worldCup, egypt);

        List<Manager> foundManagers = DBHelper.getAll(Manager.class);
        List<Player> foundPlayers = DBHelper.getAll(Player.class);
        List<Team> foundTeams = DBHelper.getAll(Team.class);
        List<ClubTeam> foundClubTeams = DBHelper.getAll(ClubTeam.class);
        List<NationalTeam> foundNationalTeams = DBHelper.getAll(NationalTeam.class);
        List<Competition> foundCompetitions = DBHelper.getAll(Competition.class);
        List<League> foundLeagues = DBHelper.getAll(League.class);
        List<Knockout> foundKnockouts = DBHelper.getAll(Knockout.class);

    }

}
