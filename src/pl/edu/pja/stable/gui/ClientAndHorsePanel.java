package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.services.dao.ClientAndHorseService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

/**
 * Created by magdalena.popek on 2017-06-16.
 */
public class ClientAndHorsePanel extends JPanel{

    ClientAndHorseService service = new ClientAndHorseService();


    public ClientAndHorsePanel() {
        super();

        JComboBox<String> chooseClientComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JTextField surnameTextField = new JTextField(columnSize);
        JTextField birthdateTextField = new JTextField(columnSize);
        JTextField phoneTextField = new JTextField(columnSize);

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz klienta"), "");
        chooseClientComboBox = chooseClientComboBox();
        this.add(chooseClientComboBox, "wrap 32");

        chooseClientComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem().equals("Nowy"))
                {
                    nameTextField.setText("");
                    nameTextField.setEnabled(true);
                    surnameTextField.setText("");
                    surnameTextField.setEnabled(true);
                    return;
                }
                System.out.println(e.getItem().toString());
                nameTextField.setText(e.getItem().toString().split(" ")[0]);
                nameTextField.setEnabled(false);
                surnameTextField.setText(e.getItem().toString().split(" ")[1]);
                surnameTextField.setEnabled(false);
            }
        });



        this.add(new JLabel("Imię:"), "");
        this.add(nameTextField, "wrap");
        this.add(new JLabel("Nazwisko:"), "");
        this.add(surnameTextField, "wrap");
        this.add(new JLabel("Data urodzenia:"), "");
        this.add(birthdateTextField, "wrap");
        this.add(new JLabel("Nr telefonu:"), "");
        this.add(phoneTextField, "wrap 32");

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseClientComboBox(){

        //JComboBox<String> clients = new JComboBox<>();
        //clients.addItem("Nowy");

        List<Client> list = service.getAllClients();

        ClientComboBoxModel clientComboBoxModel = new ClientComboBoxModel(list);

        JComboBox<String> clients = new JComboBox<>(clientComboBoxModel);

//        for (Client client: list){
//            clients.addItem(client.getName()+" "+client.getSurname());
//        }

        return clients;
    }
}