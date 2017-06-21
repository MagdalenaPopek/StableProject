package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Owner;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artur.popek on 2017-06-17.
 */
public class OwnerComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Owner> ownerList = null;
    List<String> ownerStringList = null;


    String selection = null;
    int selectIdx = 0;

    public OwnerComboBoxModel(List<Owner> ownerList) {
        start(ownerList);
    }

    private void start(List<Owner> ownerList) {
        Owner owner = new Owner();
        owner.setName("Nowy");
        owner.setSurname("");

        this.ownerList = new ArrayList<Owner>();
        this.ownerStringList = new ArrayList<String>();
        this.ownerList.add(owner);
        this.ownerList.addAll(1, ownerList);

        /**
         * Tutaj decydujemy co jest wyświetlane i jak w JComboBoxie.
         * Aktualnie Imię[SPACE]Nazwisko
         */
        for (Owner c : this.ownerList) {
            ownerStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));
        }

        selection = owner.getName();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        //System.out.println("setSelected: " + anItem);
        selectIdx = ownerStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return ownerList.size();
    }

    @Override
    public Object getElementAt(int index) {
        //System.out.println(index + "->" + ownerStringList.get(index));
        return ownerStringList.get(index);
    }

    public Owner getOwnerAt(int index) {
        return ownerList.get(index);
    }

    public Owner getSelectedOwner() {
        return ownerList.get(selectIdx);
    }

    public void refresh(List<Owner> ownerList){
        start(ownerList);
    }

    public void addOwner(Owner c){
        ownerList.add(c);
        ownerStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));

        selectIdx = ownerStringList.size()-1;
        selection = ownerStringList.get(selectIdx);
    }

}
