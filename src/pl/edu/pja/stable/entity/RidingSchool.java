package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Magdalena on 2017-05-08.
 */
@Entity
@Table(name = "riding_school")
public class RidingSchool {

    /**
     * Numer (id) szkółki jeździeckiej
     */
    @Id
    @GeneratedValue(generator = "ridingSchool_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="ridingSchool_id_seq", sequenceName="ridingSchool_id_seq")
    private int id;

    /**
     * Nazwa
     */
    @Column(name = "name")
    private String name;

    /**
     * Konie
     */
//    @ManyToOne
//    @Column(name = "horses")
//    private List<Horse> horses;

    /**
     * Instruktor prowadzący
     */
    @OneToOne(mappedBy = "ridingSchool")
    private Instructor instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Horse getHorses() {
//        return horses;
//    }
//
//    public void setHorses(List<Horse> horses) {
//        this.horses = horses;
//    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
