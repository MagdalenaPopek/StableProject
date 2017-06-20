package pl.edu.pja.stable.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Magdalena on 2017-06-20.
 */
@Entity
@Table(name = "contestant")
public class Contestant {

    @OneToMany(mappedBy = "client")
    private Client client;

    @OneToMany(mappedBy = "horse")
    private Horse horse;

    @OneToMany(mappedBy = "competition")
    private Competition competition;
}
