package pl.edu.pja.stable.entity;

import javax.persistence.*;

/**
 * Created by magdalena.popek on 2017-04-21.
 */

@Entity
@Table(name = "stall")
public class Stall {

    /**
     * Numer (id)
     */
    @Id
    @GeneratedValue(generator = "stall_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "stall_id_seq", sequenceName = "stall_id_seq", allocationSize = 1)
    private int id;

    /**
     * Numer boksu
     */
    @Column(name = "stall_nr")
    private int stallNumber;

    /**
     * Stajnia, w której boks jest
     */
    @ManyToOne()
    @JoinColumn(name = "stable_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="stable_id_fk"))
    private Stable stable;

    /**
     * Powierzchnia
     */
    @Column(name = "area")
    private double area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStallNumber() {
        return stallNumber;
    }

    public void setStallNumber(int stallNumber) {
        this.stallNumber = stallNumber;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
