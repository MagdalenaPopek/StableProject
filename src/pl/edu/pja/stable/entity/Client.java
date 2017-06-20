package pl.edu.pja.stable.entity;

/**
 * Created by Magdalena on 2017-06-16.
 */

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToOne
    private Set<Contestant> contestants = new HashSet<>();
}
