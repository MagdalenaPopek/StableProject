package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Stall;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-17.
 */
public class StallComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Stall> stallList = new ArrayList<Stall>();
    List<String> stallStringList = new ArrayList<String>();

    boolean onlyStalls = false;

    String selection = null;
    int selectIdx = 0;

    public StallComboBoxModel(List<Stall> stallList) {
        this(stallList, false);
    }

    public StallComboBoxModel(List<Stall> stallList, boolean onlyStalls) {
        this.onlyStalls = onlyStalls;
        start(stallList);
    }

    private void start(List<Stall> stallList) {

        if (!onlyStalls) {
            Stall stall = new Stall();
            stall.setStallNumber(-1);

            selection = "" + stall.getStallNumber();
            this.stallList.add(stall);
            //this.stallList.addAll(1, stallList);
        }

        this.stallList.addAll(stallList);

        /**
         * Tutaj decydujemy co jest wyświetlane i jak w JComboBoxie.
         * Aktualnie Imię[SPACE]Nazwisko
         */
        for (Stall s : this.stallList) {
            System.out.println(s.getStable());
            stallStringList.add(((s.getStable() == null) ? "" : s.getStable().getStableName() + " - ") + s.getStallNumber());
        }
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        //System.out.println("setSelected: " + anItem);
        selectIdx = stallStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public int getSize() {
        return stallList.size();
    }

    @Override
    public Object getElementAt(int index) {
        //System.out.println(index + "->" + stallStringList.get(index));
        return stallStringList.get(index);
    }

    public Stall getStallAt(int index) {
        return stallList.get(index);
    }

    public Stall getSelectedStall() {
        return stallList.get(selectIdx);
    }

    public void setSelectedStall(Stall anItem) {
        //System.out.println("setSelected: " + anItem);
        //System.out.println("setSelectedStall: " + anItem);
        if (anItem == null) {
            selectIdx = 0;
            selection = (String) stallStringList.get(selectIdx);
            return;
        }

        selectIdx = stallStringList.indexOf(((anItem.getStable() == null) ? "" : anItem.getStable().getStableName() + " - ") + anItem.getStallNumber());
        selection = (String) stallStringList.get(selectIdx);

    }

    public void refresh(List<Stall> stallList) {
        stallList = new ArrayList<Stall>();
        stallStringList = new ArrayList<String>();
        selection = null;
        selectIdx = 0;

        start(stallList);
    }

    public void addStall(Stall s) {
        stallList.add(s);
        stallStringList.add(s.getStable().getStableName() + " - " + s.getStallNumber());

        selectIdx = stallStringList.size() - 1;
        selection = stallStringList.get(selectIdx);
    }
}
