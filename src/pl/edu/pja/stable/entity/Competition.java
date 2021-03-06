package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionCategory;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;

/**
 * Created by Magdalena on 2017-04-26.
 */
@Entity
@Table(name = "competition")
public class Competition {

    /**
     * Numer (id) zawodów
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
     * Klasa zawidów
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "comp_level", nullable = false)
    private CompetitionLevel competitionLevel;

    /**
     * Kategoria zawodow
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "comp_category", nullable = false)
    private CompetitionCategory competitionCategory;

    /**
     * Nagroda
     */
    @Column(name = "prize")
    private double prize;

    /**
     * Rodzaj zawodow (skoki przez przeszkody, rajd długodystansowy)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "comp_type", nullable = false)
    private CompetitionType competitionType;

    /**
     * Czy już się odbyły
     * @return
     */
    @Column(name = "took_place")
    private boolean tookPlace;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public CompetitionCategory getCompetitionCategory() {
        return competitionCategory;
    }

    public void setCompetitionCategory(CompetitionCategory competitionCategory) {
        this.competitionCategory = competitionCategory;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public boolean isTookPlace() {
        return tookPlace;
    }

    public void setTookPlace(boolean tookPlace) {
        this.tookPlace = tookPlace;
    }
}
