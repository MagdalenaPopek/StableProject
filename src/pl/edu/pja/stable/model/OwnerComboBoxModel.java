package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Owner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-17.
 */
public class OwnerComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Owner> ownerList = new ArrayList<Owner>();
    private List<String> ownerStringList = new ArrayList<String>();

    private boolean onlyOwner = false;

    private String selection = null;
    private int selectIdx = 0;

    public OwnerComboBoxModel(List<Owner> ownerList) {
        this(ownerList, false);
    }

    public OwnerComboBoxModel(List<Owner> ownerList, boolean onlyOwner) {
        this.onlyOwner = onlyOwner;
        start(ownerList);
    }

    private void start(List<Owner> ownerList) {
        if (!onlyOwner) {
            Owner owner = new Owner();
            owner.setName("Nowy");
            owner.setSurname("");

            selection = owner.getName();
            this.ownerList.add(owner);
            this.ownerList.addAll(1, ownerList);
        } else
            this.ownerList.addAll(ownerList);

        for (Owner c : this.ownerList) {
            ownerStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));
        }
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectIdx = ownerStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public int getSize() {
        return ownerList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ownerStringList.get(index);
    }

    public Owner getOwnerAt(int index) {
        return ownerList.get(index);
    }

    public Owner getSelectedOwner() {
        return ownerList.get(selectIdx);
    }

    public void setSelectedOwner(Owner anItem) {
        if (anItem == null) {
            selectIdx = 0;
            selection = (String) ownerStringList.get(selectIdx);
            return;
        }
        selectIdx = ownerStringList.indexOf(anItem.getName() + ((anItem.getSurname().equals("")) ? "" : " " + (anItem.getSurname())));
        selection = (String) ownerStringList.get(selectIdx);
    }

    public void refresh(List<Owner> ownerList) {
        ownerList = new ArrayList<Owner>();
        ownerStringList = new ArrayList<String>();
        selection = null;
        selectIdx = 0;

        start(ownerList);
    }

    public void addOwner(Owner c) {
        ownerList.add(c);
        ownerStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));

        selectIdx = ownerStringList.size() - 1;
        selection = ownerStringList.get(selectIdx);
    }

    public boolean isOnlyOwner() {
        return onlyOwner;
    }

    public void setOnlyOwner(boolean onlyOwner) {
        this.onlyOwner = onlyOwner;
    }

}
