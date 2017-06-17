package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artur.popek on 2017-06-17.
 */
public class ClientComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Client> clientList = null;

    String selection = null;
    int    selectIdx = 0;

    public ClientComboBoxModel(List<Client> clientList){
        Client client = new Client();
        client.setName("Nowy");
        client.setSurname("");

        this.clientList = new ArrayList<Client>();
        this.clientList.add(client);
        this.clientList.addAll(clientList);
        //this.clientList = clientList;

        selection = client.getName();
    }


    @Override
    public void setSelectedItem(Object anItem) {
        selectIdx = clientList.indexOf(anItem);
        selection = ((Client) anItem).getName()+((((Client) anItem).getSurname().equals("") ) ? "" : " "+((Client) anItem).getSurname());
    }

    @Override
    public Object getSelectedItem() {
        //return clientList.get(selectIdx);
        return selection;
    }

    @Override
    public int getSize() {
        return clientList.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return clientList.get(index).getName()+((clientList.get(index).getSurname().equals("") ) ? "" : " "+(clientList.get(index).getSurname()));
        //return clientList.get(index);
    }

    public Client getClientAt(int index) {
        return clientList.get(index);
    }

    public Client getSelectedClient() {
        return clientList.get(selectIdx);
    }
}
