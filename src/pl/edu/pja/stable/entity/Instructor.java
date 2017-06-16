
package pl.edu.pja.stable.entity;

import javax.persistence.*;


/**
 * Created by Magdalena on 2017-04-23.
 */
@Entity
@Table(name = "INSTRUCTOR")
public class Instructor extends Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    /**
     * Numer odznaki
     */
    @Column(name = "odznaka_number")
    private String odznakaNumber;


    /**
     * Numer uprawnień
     */
    @Column(name = "permission_number")
    private String permissionNumber;


    /**
     * Premia od ilości jazd
     */
    @Column(name = "lesson_bonus")
    private double lessonBonus = 10;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getOdznakaNumber() {
        return odznakaNumber;
    }

    public void setOdznakaNumber(String odznakaNumber) {
        this.odznakaNumber = odznakaNumber;
    }

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public double getLessonBonus() {
        return lessonBonus;
    }

    public void setLessonBonus(double lessonBonus) {
        this.lessonBonus = lessonBonus;
    }
}

