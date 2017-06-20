package pl.edu.pja.stable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Magdalena on 2017-06-20.
 */
@Entity
@Table(name = "contestant")
public class Contestant {

    private Client client;

    private Horse horse;
}
