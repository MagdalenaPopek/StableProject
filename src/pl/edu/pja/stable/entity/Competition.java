package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;

/**
 * Created by Magdalena on 2017-04-26.
 */
@Entity
public abstract class Competition {

    /**
     * Numer (id) zawodów w skokach przez przeszkody
     */
    @Id
    @GeneratedValue(generator = "competition_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "competition_id_seq", sequenceName = "competition_id_seq", allocationSize = 1)
    private int id;

    /**
     * Nazwa
     */
    @Column(name = "comp_name", nullable = false)
    private String compName;

    /**
     * Klasa
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "comp_level", nullable = false)
    private CompetitionLevel competitionLevel;

    /**
     * Data
     */
//    @Column(name = "date", nullable = false)
//    private Date date;

    /**
     * Rodzaj zawodow
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "comp_type", nullable = false)
    private CompetitionType competitionType;

    /**
     * Nagroda
     */
    @Column(name = "prize")
    private double prize;

    /**
     * Liczba przeszkód
     */
    @Column(name = "number_obstacles", nullable = false)
    private int numberOfObstacles;

    /**
     * Distance
     */
    @Column(name = "distance", nullable = false)
    private double distance;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public CompetitionLevel getCompetitionLevel() {
        return competitionLevel; }

    public void setCompetitionLevel(CompetitionLevel competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

/*    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
