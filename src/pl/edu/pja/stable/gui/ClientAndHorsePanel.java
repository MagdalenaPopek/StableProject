package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by artur.popek on 2017-06-16.
 */
public class ClientAndHorsePanel extends JPanel{


    public ClientAndHorsePanel() {
        super();

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz klienta"), "");
        this.add(chooseClientComboBox(), "wrap 32");

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JTextField surnameTextField = new JTextField(columnSize);
        JTextField birthdateTextField = new JTextField(columnSize);
        JTextField phoneTextField = new JTextField(columnSize);

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
        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseClientComboBox(){

        JComboBox<String> clients = new JComboBox<>();
        clients.addItem("Nowy");
        clients.addItem("Klient 1");
        clients.addItem("Klient 2");
        clients.addItem("Klient 3");

        return clients;
    }
}