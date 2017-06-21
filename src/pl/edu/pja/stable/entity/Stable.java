package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Magdalena Popek on 2017-04-21.
 */

@Entity
@Table(name="stable")
public class Stable {

    /**
     * Numer (id)
     */
    @Id
    @GeneratedValue(generator = "stable_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="stable_id_seq", sequenceName="stable_id_seq", allocationSize = 1)
    private int id;

    /**
     * Nazwa
     */
    @Column(name = "stable_name")
    private String stableName;

    /**
     * Adres
     */
    @Column(name = "stable_address")
    private String stableAddress;

    /**
     * Dyrektor stajni
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="director_id_fk"))
    private Employee director;

    /**
     * Boksy
     */
    @OneToMany(mappedBy = "stable")
    private List<Stall> stalls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStableName() {
        return stableName;
    }

    public void setStableName(String stableName) {
        this.stableName = stableName;
    }

    public String getStableAddress() {
        return stableAddress;
    }

    public void setStableAddress(String stableAddress) {
        this.stableAddress = stableAddress;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public List<Stall> getStalls() {
        return stalls;
    }

    public void setStalls(List<Stall> stalls) {
        this.stalls = stalls;
    }
}
