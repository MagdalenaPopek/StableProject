package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
@Entity
@Table(name = "show_jumping")
public class ShowJumping extends Competition {

    /**
     * Numer (id) zawodów w skokach przez przeszkody
     */
    @Id
    @GeneratedValue(generator = "jump_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="jump_id_seq", sequenceName="jump_id_seq", allocationSize = 1)
    private int id;

    /**
     * Liczba przeszkód
     */
    @Column(name = "number_obstacles", nullable = false)
    private int numberOfObstacles;

    /**
     * Referencja do Zawodów
     */
    private Competition competition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
