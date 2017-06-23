package pl.edu.pja.stable.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends Person { //Client?

    /**
     * Numer (id) właściciela
     */
    @Id
    @GeneratedValue(generator = "owner_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="owner_id_seq", sequenceName="owner_id_seq", allocationSize = 1)
    private int id;

    /**
     * Konie, które posiada
     */
    @OneToMany(mappedBy = "owner", orphanRemoval=true)
    //@JoinColumn(name="ID") // join column is in table for Order
    private List<Horse> horses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "horse")
    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

}