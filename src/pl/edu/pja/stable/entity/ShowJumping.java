package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public class ShowJumping extends Competition {

    @Id
    @GeneratedValue(generator = "jump_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="jump_id_seq", sequenceName="jump_id_seq", allocationSize = 1)
    /**
     * Numer (id) zawodów w skokach przez przeszkody
     */
    private int id;

    @Column(name = "numberOfObstacles", nullable = false)
    /**
     * Liczba przeszkód
     */
    private int numberOfObstacles;

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
}
