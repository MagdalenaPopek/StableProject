package pl.edu.pja.stable.entity;

import java.util.ArrayList;

/**
 * Created by Magdalena on 2017-05-08.
 */
public class RidingSchool {

    /**
     * Nazwa
     */
    private String name;

    /**
     * Konie
     */
    private ArrayList<Horse> horses = new ArrayList<>();

    public RidingSchool(String name) {
        this.name = name;
    }


}
