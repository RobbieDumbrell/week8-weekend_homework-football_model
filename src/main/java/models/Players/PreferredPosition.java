package models.Players;

public enum PreferredPosition {

    GOALKEEPER("GK"),
    DEFENDER("DEF"),
    MIDFIELDER("MID"),
    FORWARD("FWD");

    String abbreviatedName;

    PreferredPosition(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }
}
