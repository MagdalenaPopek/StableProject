package pl.edu.pja.stable.entity;

import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public class ShowJumping extends Competition {

    /**
     * Liczba przeszkód
     */
    private int numberOfObstacles;

    public ShowJumping(String compName, CompetitionLevel competitionLevel, Date date, double price, int numberOfObstacles) {
        super(compName, competitionLevel, date, price);
        this.numberOfObstacles = numberOfObstacles;
    }

    public ShowJumping(String compName, CompetitionLevel competitionLevel, Date date, int maxContestantNumber, int numberOfObstacles) {
        super(compName, competitionLevel, date, maxContestantNumber);
        this.numberOfObstacles = numberOfObstacles;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }

    @Override
    public void setPrize(double prize) {
        super.setPrize(prize + prize * numberOfObstacles / 10);
    }

    @Override
    public String toString() {
        if (getCompetitionType() == CompetitionType.Ogolnopolskie) {
            return "Zawody ogólnopolskie w skokach " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", wpisowe " + getPrice() +
                    ", liczba przeszkód " + numberOfObstacles;
        } else
            return "Zawody regionalne w skokach " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", maksymalna liczba zawodników " + getMaxContestantNumber() +
                    ", liczba przeszkód " + numberOfObstacles;
    }
}
