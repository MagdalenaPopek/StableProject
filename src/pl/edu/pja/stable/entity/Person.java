package pl.edu.pja.stable.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-04-22.
 */

@MappedSuperclass
public class Person {

    /**
     * Imię
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Nazwisko
     */
    @Column(name = "surname", nullable = false)
    private String surname;

    /**
     * Numer telefonu
     */
    @Column(name = "phone_number")
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
