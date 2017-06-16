
package pl.edu.pja.stable.entity;

import javax.persistence.*;


/**
 * Created by Magdalena on 2017-04-22.
 */
@Entity
@Table(name = "GROOM")
public class Groom extends Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    /**
     * Premia od ilości wykonanych zadań
     */

    private double tasksBonus = 20;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getTasksBonus() {
        return tasksBonus;
    }

    public void setTasksBonus(double tasksBonus) {
        this.tasksBonus = tasksBonus;
    }
}

