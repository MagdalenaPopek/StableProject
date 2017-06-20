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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
