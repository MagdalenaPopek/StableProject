package pl.edu.pja.stable.entity;

/**
 * Created by Magdalena on 2017-06-16.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends Person{

    @Id
    @GeneratedValue(generator = "client_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="client_id_seq", sequenceName="client_id_seq", allocationSize = 1)
    /**
     * Numer (id) klienta
     */
    private int id;

    /**
     * Zawodnicy
     */
    @OneToMany(mappedBy = "client")
    private List<Contestant> contestants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
    }
}
