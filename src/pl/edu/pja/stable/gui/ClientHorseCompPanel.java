package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Contestant;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.model.ClientCompComboBoxModel;
import pl.edu.pja.stable.model.CompetitionComboBoxModel;
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

    CompetitionService competitionService;
    CompetitionComboBoxModel competitionComboBoxModel;



    public ClientHorseCompPanel(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

        JComboBox<String> chooseClientComboBox;
        JComboBox<String> chooseHorseComboBox;
        JComboBox<String> chooseCompetitionComboBox;

        int columnSize = 32;

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz klienta"), "");
        chooseClientComboBox = chooseClientComboBox();
        this.add(chooseClientComboBox, "wrap 32");

        this.add(new JLabel("Wybierz konia"), "");
        chooseHorseComboBox = chooseHorseComboBox();
        this.add(chooseHorseComboBox, "wrap 32");

        this.add(new JLabel("Wybierz zawody"), "");
        chooseCompetitionComboBox = chooseCompetitionComboBox();
        this.add(chooseCompetitionComboBox, "wrap 32");

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contestant c = new Contestant();
                c.setClient(clientCompComboBoxModel.getSelectedClient());
                c.setHorse(horseComboBoxModel.getSelectedHorse());
                c.setCompetition(competitionComboBoxModel.getSelectedCompetition());
               // c.setContestantNumber();

            }
        });


        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new AboutPanel());
                mainFrame.pack();
            }
        });

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

    private JComboBox<String> chooseHorseComboBox() {
        horseComboBoxModel = new HorseComboBoxModel(horseService.getAllHorses());
        JComboBox<String> clients = new JComboBox<>(clientCompComboBoxModel);
        return clients;
    }

    private JComboBox<String> chooseCompetitionComboBox() {
        competitionComboBoxModel = new CompetitionComboBoxModel(competitionService.getAllCompetitions());
        JComboBox<String> clients = new JComboBox<>(clientCompComboBoxModel);
        return clients;
    }

}
