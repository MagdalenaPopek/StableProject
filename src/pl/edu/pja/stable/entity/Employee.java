package pl.edu.pja.stable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Magdalena on 2017-06-07.
 */
@Entity
@Table(name = "employee")
public class Employee extends Person {


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