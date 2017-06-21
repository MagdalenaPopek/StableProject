package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Owner;
import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.model.OwnerComboBoxModel;
import pl.edu.pja.stable.services.dao.OwnerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

/**
 * Created by magdalena.popek on 2017-06-16.
 */
public class OwnerPanel extends JPanel {

    OwnerService service = new OwnerService();
    OwnerComboBoxModel ownerComboBoxModel;

    public OwnerPanel() {
        super();

        JComboBox<String> chooseOwnerComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JTextField surnameTextField = new JTextField(columnSize);
        JTextField birthdateTextField = new JTextField(columnSize);
        JTextField phoneTextField = new JTextField(columnSize);

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz właściciela"), "");
        chooseOwnerComboBox = chooseOwnerComboBox();
        this.add(chooseOwnerComboBox, "wrap 32");

        chooseOwnerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().equals("Nowy")) {
                    nameTextField.setText("");
                    nameTextField.setEnabled(true);
                    surnameTextField.setText("");
                    surnameTextField.setEnabled(true);
                    birthdateTextField.setText("");
                    birthdateTextField.setEnabled(true);
                    phoneTextField.setText("");
                    phoneTextField.setEnabled(true);
                    return;
                }

                //System.out.println(e.getItem().toString());
                Owner c = ownerComboBoxModel.getSelectedOwner();
                nameTextField.setText(c.getName());
                nameTextField.setEnabled(false);
                surnameTextField.setText(c.getSurname());
                surnameTextField.setEnabled(false);
                birthdateTextField.setText((c.getBirthDate() == null ) ? "" : c.getBirthDate().toString());
                birthdateTextField.setEnabled(false);
                phoneTextField.setText(c.getPhoneNumber());
                phoneTextField.setEnabled(false);

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

        //TODO
        // Brakuje innych pól z Entity Owner

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chooseOwnerComboBox.getSelectedItem().equals("Nowy")) {
                    System.out.println("Dodaję nowego właściciela...");
                    Owner o = new Owner();
                    o.setName(nameTextField.getText());
                    o.setSurname(surnameTextField.getText());
                    o.setBirthDate(new Date());
                    o.setPhoneNumber(phoneTextField.getText());
                    service.saveOwner(o);

                    ownerComboBoxModel.addOwner(o);
                    chooseOwnerComboBox.updateUI();
                    chooseOwnerComboBox.setSelectedIndex(chooseOwnerComboBox.getItemCount()-1);
                }
            }
        });

        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseOwnerComboBox() {
        ownerComboBoxModel = new OwnerComboBoxModel(service.getAllOwners());
        JComboBox<String> clients = new JComboBox<>(ownerComboBoxModel);
        return clients;
    }
}