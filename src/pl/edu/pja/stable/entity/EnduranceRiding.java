package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public class EnduranceRiding extends Competition {

    /**
     * Distance
     */
    private double distance;

    public EnduranceRiding(String compName, CompetitionLevel competitionLevel, Date date, double price, double distance) {
        super(compName, competitionLevel, date, price);
        this.distance = distance;
    }

    public EnduranceRiding(String compName, CompetitionLevel competitionLevel, Date date, int maxContestantNumber, double distance) {
        super(compName, competitionLevel, date, maxContestantNumber);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void setPrize(double prize) {
        super.setPrize(prize + prize * distance / 12);
    }

    @Override
    public String toString() {
        if (getCompetitionType() == CompetitionType.Ogolnopolskie) {
            return "Ogólnopolski rajd konny " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", wpisowe " + getPrice() +
                    ", liczba przeszkód " + distance;
        } else
            return "Regionalny rajd konny " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", maksymalna liczba zawodników " + getMaxContestantNumber() +
                    ", liczba przeszkód " + distance;
    }
}
