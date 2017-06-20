package pl.edu.pja.stable.entity;

import pl.edu.pja.stable.entityutils.HorseGender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "horse",
        uniqueConstraints = @UniqueConstraint(columnNames = "passport_nr", name = "passport_nr_unq"))
public class Horse {

    /**
     * Numer (id) konia
     */
    @Id
    @GeneratedValue(generator = "horse_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="horse_id_seq", sequenceName="horse_id_seq")
    private int id;

    /**
     * Imię
     */
    @Column(name = "name")
    private String name;

    /**
     * Data urodzenia
     */
//    @Column(name = "birth_date")
//    private Date birthDate;

    /**
     * Numer paszportu
     */
    @Column(name = "passport_nr")
    private String passportNumber;

    /**
     * Płeć
     */
    @Column(name = "gender")
    private HorseGender gender;

    /**
     * Właściciel
     */
    //@ManyToOne
    //@JoinColumn(name = "id", nullable = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="owner_id_fk"))
    private Owner owner;

    /**
     * Boks
     */
    @OneToOne
    @JoinColumn(name="stall_id",foreignKey=@ForeignKey(name="stall_id_fk"))
    private Stall stall;

    //private Boolean isShowHorse;

    /**
     * Szkółka jeździecka
     */
    @OneToMany(mappedBy = "ridingSchool")
    @JoinColumn(name="ridingSchool_id",foreignKey=@ForeignKey(name="ridingSchool_id_fk"))
    private RidingSchool ridingSchool;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }*/

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public HorseGender getGender() {
        return gender;
    }

    public void setGender(HorseGender gender) {
        this.gender = gender;
    }


    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    @ManyToOne
    @JoinColumn(name = "ID", nullable = false)
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}