package pl.edu.pja.stable.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends Person { //Client?

    @Id
    @GeneratedValue(generator = "owner_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="owner_id_seq", sequenceName="owner_id_seq", allocationSize = 1)
    /**
     * Numer (id) właściciela
     */
    private int id;

    @Column(name = "percentage")
    private double percentage = 10;
    /**
     * Opłata
     */
    @Column(name = "charge")
    private double charge;

    @Column(name = "max_charge")
    private double maxCharge;

    /**
     * Konie, które posiada
     */
    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })*/
    @OneToMany(mappedBy = "horse", orphanRemoval=true)
    @JoinTable(name = "horses", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
    @JoinColumn(name="ID") // join column is in table for Order
    private Set<Horse> horses = new HashSet<Horse>(0);

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getMaxCharge() {
        return maxCharge;
    }

    public void setMaxCharge(double maxCharge) {
        this.maxCharge = maxCharge;
    }

    public Set<Horse> getHorses() {
        return horses;
    }

    public void setHorses(Set<Horse> horses) {
        this.horses = horses;
    }

}