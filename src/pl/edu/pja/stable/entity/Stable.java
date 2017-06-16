package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

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
    private String stableName;

    /**
     * Adres
     */
    private String stableAddress;

    /**
     * NIP
     */
    private String nip;

    /**
     * Dyrektor stajni
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="employee_id_fk"))
    private Employee director;

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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }
}
