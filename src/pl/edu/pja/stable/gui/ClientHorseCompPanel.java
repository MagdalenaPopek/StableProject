package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.model.ClientCompComboBoxModel;
import pl.edu.pja.stable.model.HorseComboBoxModel;
import pl.edu.pja.stable.services.dao.ClientService;
import pl.edu.pja.stable.services.dao.CompetitionService;
import pl.edu.pja.stable.services.dao.HorseService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class ClientHorseCompPanel extends JPanel{

    JFrame mainFrame;
    ClientService clientService = new ClientService();
    ClientCompComboBoxModel clientCompComboBoxModel;

    HorseService horseService = new HorseService();
    HorseComboBoxModel horseComboBoxModel;



    public ClientHorseCompPanel(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

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

/*        this.add(new JLabel("Wybierz klienta"), "");
        chooseHorseComboBox = chooseClientComboBox();
        this.add(chooseClientComboBox, "wrap 32");

        this.add(new JLabel("Wybierz klienta"), "");
        chooseCompetitionComboBox = chooseClientComboBox();
        this.add(chooseClientComboBox, "wrap 32");*/

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new AboutPanel());
                mainFrame.pack();
            }
        });

/*        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chooseClientComboBox.getSelectedItem().equals("Nowy")) {
                    System.out.println("Dodaję nowego klienta...");
                    Client c = new Client();
                    c.setName(nameTextField.getText());
                    c.setSurname(surnameTextField.getText());
                    c.setPhoneNumber(phoneTextField.getText());
                    clientService.saveClient(c);

                    clientComboBoxModel.addClient(c);
                    chooseClientComboBox.updateUI();
                    chooseClientComboBox.setSelectedIndex(chooseClientComboBox.getItemCount()-1);
                }
            }
        });*/

        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseClientComboBox() {
        clientCompComboBoxModel = new ClientCompComboBoxModel(clientService.getAllClients());
        JComboBox<String> clients = new JComboBox<>(clientCompComboBoxModel);
        return clients;
    }

}
