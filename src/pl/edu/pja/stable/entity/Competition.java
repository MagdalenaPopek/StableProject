package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
@MappedSuperclass
public abstract class Competition {

    /**
     * Nazwa
     */
    @Column(name = "compName", nullable = false)
    private String compName;

    /**
     * Klasa
     */
    @Column(name = "competitonLevel", nullable = false)
    private CompetitionLevel competitionLevel;

    /**
     * Data
     */
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * Rodzaj zawodow
     */
    @Column(name = "competitionType", nullable = false)
    private CompetitionType competitionType;

    /**
     * Nagroda
     */
    @Column(name = "prize")
    private double prize;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public CompetitionLevel getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(CompetitionLevel competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
}
