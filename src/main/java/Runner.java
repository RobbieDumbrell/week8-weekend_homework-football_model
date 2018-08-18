import db.DBHelper;
import db.DBKnockouts;
import db.DBLeagues;
import models.Competitions.Competition;
import models.Competitions.Knockout;
import models.Competitions.League;
import models.Players.Player;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;
import models.Teams.Team;

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

        DBKnockouts.addTeamTo(faCup, liverpool);
        DBKnockouts.addTeamTo(faCup, manCity);
        DBKnockouts.addTeamTo(faCup, manUtd);
        DBKnockouts.addTeamTo(faCup, burnley);
        DBKnockouts.addTeamTo(leagueCup, liverpool);
        DBKnockouts.addTeamTo(leagueCup, manCity);
        DBKnockouts.addTeamTo(leagueCup, manUtd);
        DBKnockouts.addTeamTo(leagueCup, burnley);
        DBKnockouts.addTeamTo(worldCup, england);
        DBKnockouts.addTeamTo(worldCup, belgium);
        DBKnockouts.addTeamTo(worldCup, brazil);
        DBKnockouts.addTeamTo(worldCup, egypt);

        List<Manager> foundManagers = DBHelper.getAll(Manager.class);
        List<Player> foundPlayers = DBHelper.getAll(Player.class);
        List<Team> foundTeams = DBHelper.getAll(Team.class);
        List<ClubTeam> foundClubTeams = DBHelper.getAll(ClubTeam.class);
        List<NationalTeam> foundNationalTeams = DBHelper.getAll(NationalTeam.class);
        List<Competition> foundCompetitions = DBHelper.getAll(Competition.class);
        List<League> foundLeagues = DBHelper.getAll(League.class);
        List<Knockout> foundKnockouts = DBHelper.getAll(Knockout.class);

        premierLeague.playGame(liverpool, burnley);
        premierLeague.playGame(liverpool, manUtd);
        premierLeague.playGame(liverpool, manCity);
        premierLeague.playGame(burnley, liverpool);
        premierLeague.playGame(manUtd, liverpool);
        premierLeague.playGame(manCity, liverpool);

        premierLeague.playGame(burnley, manCity);
        premierLeague.playGame(burnley, manUtd);
        premierLeague.playGame(manCity, burnley);
        premierLeague.playGame(manUtd, manCity);

        premierLeague.playGame(manUtd, manCity);
        premierLeague.playGame(manCity, manUtd);

        DBHelper.update(liverpool);
        DBHelper.update(manCity);
        DBHelper.update(manUtd);
        DBHelper.update(burnley);

        List<Team> premierLeagueStandings = DBLeagues.getLeagueStandings(premierLeague);
    }

}
