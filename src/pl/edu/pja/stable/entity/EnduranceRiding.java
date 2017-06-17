package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public class EnduranceRiding extends Competition {

    @Id
    @GeneratedValue(generator = "endrid_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="endrid_id_seq", sequenceName="endrid_id_seq", allocationSize = 1)
    /**
     * Numer (id) rajdu długodystansowego
     */
    private int id;

    @Column(name = "distance", nullable = false)
    /**
     * Distance
     */
    private double distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
