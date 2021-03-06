
package pl.edu.pja.stable.entity;

import javax.persistence.*;


/**
 * Created by Magdalena on 2017-04-23.
 */
@Entity
@Table(name = "instructor")
public class Instructor extends Employee{

    /**
     * Numer (id) instruktora
     */
    @Id
    @GeneratedValue(generator = "instructor_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="instructor_id_seq", sequenceName="instructor_id_seq", allocationSize = 1)
    private int id;

    /**
     * Numer odznaki
     */
    @Column(name = "ridingcard_number")
    private String ridingCardNumber;

    /**
     * Numer uprawnień
     */
    @Column(name = "permission_number")
    private String permissionNumber;


    /**
     * Referencja do pracowników
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="employee_id_fk"))
    private Employee employee;

    /**
     * Szkółka
     */
    @OneToOne
    @JoinColumn(name = "riding_school_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="riding_school_id_fk"))
    private RidingSchool ridingSchool;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRidingCardNumber() {
        return ridingCardNumber;
    }

    public void setRidingCardNumber(String ridingCardNumber) {
        this.ridingCardNumber = ridingCardNumber;
    }

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

