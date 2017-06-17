
package pl.edu.pja.stable.entity;

import javax.persistence.*;


/**
 * Created by Magdalena on 2017-04-23.
 */
@Entity
@Table(name = "INSTRUCTOR")
public class Instructor extends Person {

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

}

