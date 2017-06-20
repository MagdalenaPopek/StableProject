package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-17.
 */
public class ClientComboBoxModel extends AbstractListModel implements ComboBoxModel {

    List<Client> clientList = null;
    List<String> clientStringList = null;


    String selection = null;
    int selectIdx = 0;

    public ClientComboBoxModel(List<Client> clientList) {
        start(clientList);
    }

    private void start(List<Client> clientList) {
        Client client = new Client();
        client.setName("Nowy");
        client.setSurname("");

        this.clientList = new ArrayList<Client>();
        this.clientStringList = new ArrayList<String>();
        this.clientList.add(client);
        this.clientList.addAll(1, clientList);

        /**
         * Tutaj decydujemy co jest wyświetlane i jak w JComboBoxie.
         * Aktualnie Imię[SPACE]Nazwisko
         */
        for (Client c : this.clientList) {
            clientStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));
        }

        selection = client.getName();
    }


    @Override
    public void setSelectedItem(Object anItem) {
        //System.out.println("setSelected: " + anItem);
        selectIdx = clientStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return clientList.size();
    }

    @Override
    public Object getElementAt(int index) {
        //System.out.println(index + "->" + clientStringList.get(index));
        return clientStringList.get(index);
    }

    public Client getClientAt(int index) {
        return clientList.get(index);
    }

    public Client getSelectedClient() {
        return clientList.get(selectIdx);
    }

    public void refresh(List<Client> clientList){
        start(clientList);
    }

    public void addClient(Client c){
        clientList.add(c);
        clientStringList.add(c.getName() + ((c.getSurname().equals("")) ? "" : " " + (c.getSurname())));

        selectIdx = clientStringList.size()-1;
        selection = clientStringList.get(selectIdx);
    }

}
