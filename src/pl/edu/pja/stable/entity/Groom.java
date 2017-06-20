
package pl.edu.pja.stable.entity;

import javax.persistence.*;


/**
 * Created by Magdalena on 2017-04-22.
 */
@Entity
@Table(name = "groom")
public class Groom {

    @Id
    @GeneratedValue(generator = "groom_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="groom_id_seq", sequenceName="groom_id_seq", allocationSize = 1)
    /**
     * Numer (id) stajennego
     */
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="employee_id_fk"))
    /**
     * Referencja do pracowników
     */
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

