package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public abstract class Competition {

    /**
     * Nazwa
     */
    private String compName;

    /**
     * Klasa
     */
    private CompetitionLevel competitionLevel;

    /**
     * Data
     */
    private Date date;

    /**
     * Rodzaj zawodow
     */
    private CompetitionType competitionType;

    /**
     * Nagroda
     */
    private double prize;

    //--------OGÓLNOPOLSKIE--------
    private double price;

    //--------REGIONALNE--------
    private int maxContestantNumber;

    public Competition(String compName, CompetitionLevel competitionLevel, Date date, double price) {
        this.compName = compName;
        this.competitionLevel = competitionLevel;
        this.date = date;
        this.price = price;
        this.competitionType = CompetitionType.Ogolnopolskie;
    }

    public Competition(String compName, CompetitionLevel competitionLevel, Date date, int maxContestantNumber) {
        this.compName = compName;
        this.competitionLevel = competitionLevel;
        this.date = date;
        this.maxContestantNumber = maxContestantNumber;
        this.competitionType = CompetitionType.Regionalne;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public double getPrize() {
        return prize;
    }

    public String getCompName() {
        return compName;
    }

    public CompetitionLevel getCompetitionLevel() {
        return competitionLevel;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxContestantNumber() {
        return maxContestantNumber;
    }
}
