package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Horse;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-17.
 */
public class HorseComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Horse> horseList = new ArrayList<Horse>();
    List<String> horseStringList = new ArrayList<String>();
    boolean onlyHorse = false;
    String selection = null;
    int selectIdx = 0;

    public HorseComboBoxModel(List<Horse> horseList) {
        this(horseList, false);
    }
    public HorseComboBoxModel(List<Horse> horseList, boolean onlyHorse) {
        this.onlyHorse = onlyHorse;
        start(horseList);
    }

    public boolean isOnlyHorse() {
        return onlyHorse;
    }

    public void setOnlyHorse(boolean onlyHorse) {
        this.onlyHorse = onlyHorse;
    }

    private void start(List<Horse> horseList) {

        if (!onlyHorse) {
            Horse horse = new Horse();
            horse.setName("Nowy");

            selection = horse.getName();
            this.horseList.add(horse);
            //this.horseList.addAll(1, horseList);
        }

        this.horseList.addAll(horseList);

        /**
         * Tutaj decydujemy co jest wyświetlane i jak w JComboBoxie.
         * Aktualnie Imię[SPACE]Nazwisko
         */
        for (Horse h : this.horseList) {
            horseStringList.add(h.getName() + ((h.getGender() == null) ? "" : " " + h.getGender()));
        }
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectIdx = horseStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public int getSize() {
        return horseList.size();
    }

    @Override
    public Object getElementAt(int index) {
        //System.out.println(index + "->" + horseStringList.get(index));
        return horseStringList.get(index);
    }

    public Horse getHorseAt(int index) {
        return horseList.get(index);
    }

    public Horse getSelectedHorse() {
        return horseList.get(selectIdx);
    }

    public void refresh(List<Horse> horseList) {
        horseList = new ArrayList<Horse>();
        horseStringList = new ArrayList<String>();
        selection = null;
        selectIdx = 0;

        start(horseList);
    }

    public void addHorse(Horse h) {
        horseList.add(h);
        horseStringList.add(h.getName() + " " + h.getGender());

        selectIdx = horseStringList.size() - 1;
        selection = horseStringList.get(selectIdx);
    }
}
