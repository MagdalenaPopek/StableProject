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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stable_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="stable_id_fk"))
    private Stable stable;

    /**
     * Powierzchnia
     */
    @Column(name = "area")
    private double area;

}
