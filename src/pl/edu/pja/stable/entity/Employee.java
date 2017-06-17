package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Magdalena on 2017-06-07.
 */
@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Id
    @GeneratedValue(generator = "person_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="person_id_seq", sequenceName="person_id_seq", allocationSize = 1)
    /**
     * Numer (id) użytkownika
     */
    private int id;

    @Column(name = "HIRE_DATE", nullable = false)
    private Date hireDate;

    @Column(name = "SALARY", nullable = false)
    private double salary;


    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}