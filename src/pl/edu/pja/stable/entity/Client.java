package pl.edu.pja.stable.entity;

/**
 * Created by Magdalena on 2017-06-16.
 */

import javax.persistence.*;

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
}
