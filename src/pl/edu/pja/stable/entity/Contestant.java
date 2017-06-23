package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-20.
 */
@Entity
@Table(name = "contestant", uniqueConstraints = @UniqueConstraint(columnNames = "client_id"))
public class Contestant {

    /**
     * Numer (id)
     */
    @Id
    @GeneratedValue(generator = "contestant_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="contestant_id_seq", sequenceName="contestant_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "client_id_fk"), unique = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "horse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "horse_id_fk"))
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "competition_id_fk"))
    private Competition competition;

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "contestant_number")
    private int contestantNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getContestantNumber() {
        return contestantNumber;
    }

    public void setContestantNumber(int contestantNumber) {
        this.contestantNumber = contestantNumber;
    }
}
