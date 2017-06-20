package pl.edu.pja.stable.entity;

import javax.persistence.*;
import java.util.ArrayList;

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
    @ManyToOne
    @Column(name = "horses")
    private ArrayList<Horse> horses = new ArrayList<>();

    /**
     * Instruktor prowadzący
     */
    @OneToMany(mappedBy = "instructor")
    @Column(name = "instructor")
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

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
