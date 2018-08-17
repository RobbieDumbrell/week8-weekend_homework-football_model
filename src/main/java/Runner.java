import db.DBHelper;
import models.Players.Player;
import models.Staff.Manager;
import models.Teams.ClubTeam;
import models.Teams.NationalTeam;

public class Runner {

    public static void main(String[] args) {

        Manager klopp = new Manager("Jurgen Klopp", 45, "4-3-3");
        Manager mourinho = new Manager("Jose Mourinho", 50, "4-4-2");
        Manager guardiola = new Manager("Josep Guardiola", 42, "4-3-2-1");
        Manager southgate = new Manager("Gareth Southgate", 48, "5-3-2");
        Manager martinez = new Manager("Roberto Martinez", 40, "4-4-1-1");
        Manager anEgyptianManager = new Manager("Mr. Egypt", 50, "4-5-1");
        Manager aBrazilianManager = new Manager("Mr. Brazil", 60, "4-2-4");

        DBHelper.save(klopp);
        DBHelper.save(mourinho);
        DBHelper.save(guardiola);
        DBHelper.save(southgate);
        DBHelper.save(martinez);
        DBHelper.save(anEgyptianManager);
        DBHelper.save(aBrazilianManager);

        NationalTeam england = new NationalTeam("England", southgate);
        NationalTeam belgium = new NationalTeam("Belgium", martinez);
        NationalTeam egypt = new NationalTeam("Egypt", anEgyptianManager);
        NationalTeam brazil = new NationalTeam("Brazil", aBrazilianManager);

        DBHelper.save(england);
        DBHelper.save(belgium);
        DBHelper.save(egypt);
        DBHelper.save(brazil);

        ClubTeam liverpool = new ClubTeam("Liverpool", klopp, 100);
        ClubTeam manUtd = new ClubTeam("Manchester United", mourinho, 150);
        ClubTeam manCity = new ClubTeam("Manchester City", guardiola, 200);

        DBHelper.save(liverpool);
        DBHelper.save(manUtd);
        DBHelper.save(manCity);

        Player salah = new Player("Mohamed Salah", 26, 65, liverpool, egypt);
        Player firmino = new Player("Roberto Firmino", 25, 50, liverpool, brazil);
        Player sterling = new Player("Raheem Stirling", 24, 40, manCity, england);
        Player deBruyne = new Player("Kevin De Bruyne", 26, 70, manCity, belgium);
        Player lukaku = new Player("Romelu Lukaku", 25, 55, manUtd, belgium);
        Player jesus = new Player("Gabriel Jesus", 21, 30, manCity, brazil);
        Player rashford = new Player("Marcus Rashford", 20, 35, manUtd, england);
        Player fred = new Player("Fred", 27, 25, manUtd, brazil);
        Player henderson = new Player("Jordan Henderson", 27, 15, liverpool, england);

        DBHelper.save(salah);
        DBHelper.save(firmino);
        DBHelper.save(sterling);
        DBHelper.save(deBruyne);
        DBHelper.save(lukaku);
        DBHelper.save(jesus);
        DBHelper.save(rashford);
        DBHelper.save(fred);
        DBHelper.save(henderson);

    }

}
