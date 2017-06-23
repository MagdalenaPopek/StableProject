package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Contestant;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.model.ClientCompComboBoxModel;
import pl.edu.pja.stable.model.CompetitionComboBoxModel;
import pl.edu.pja.stable.model.HorseComboBoxModel;
import pl.edu.pja.stable.services.dao.ClientService;
import pl.edu.pja.stable.services.dao.CompetitionService;
import pl.edu.pja.stable.services.dao.ContestantService;
import pl.edu.pja.stable.services.dao.HorseService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class ClientHorseCompPanel extends JPanel{

    JFrame mainFrame;

    ContestantService contestantService = new ContestantService();

    ClientService clientService = new ClientService();
    ClientComboBoxModel clientComboBoxModel;

    HorseService horseService = new HorseService();
    HorseComboBoxModel horseComboBoxModel;

    CompetitionService competitionService = new CompetitionService();
    CompetitionComboBoxModel competitionComboBoxModel;



    public ClientHorseCompPanel(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

        int columnSize = 32;

        JComboBox<String> chooseClientComboBox;
        JComboBox<String> chooseHorseComboBox;
        JComboBox<String> chooseCompetitionComboBox;

        JTextField clientNameTextField = new JTextField(columnSize);
        JTextField clientSurnameTextField = new JTextField(columnSize);
        JTextField horseNameTextField = new JTextField(columnSize);
        JTextField competitionNameTextField = new JTextField(columnSize);
        JTextField contestantNumberTextField = new JTextField(columnSize);


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

        this.add(new JLabel("Imię:"), "");
        this.add(clientNameTextField, "wrap");
        clientNameTextField.setEnabled(false);

        this.add(new JLabel("Nazwisko:"), "");
        this.add(clientSurnameTextField, "wrap");
        clientSurnameTextField.setEnabled(false);

        this.add(new JLabel("Koń:"), "");
        this.add(horseNameTextField, "wrap");
        horseNameTextField.setEnabled(false);

        this.add(new JLabel("Zawody:"), "");
        this.add(competitionNameTextField, "wrap 32");
        competitionNameTextField.setEnabled(false);

        this.add(new JLabel("Numer zawodnika:"), "");
        this.add(contestantNumberTextField, "wrap 32");
        contestantNumberTextField.setEnabled(false);


        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientComboBoxModel.getSelectedItem().equals("Nowy")) {
                    JOptionPane.showMessageDialog(mainFrame, "Nie znaleziono klienta. Wprowadź innego albo zarejestruj klienta w Słowniki > Klienci");
                }
                if (horseComboBoxModel.getSelectedItem().equals("Nowy")){
                    JOptionPane.showMessageDialog(mainFrame, "Nie znaleziono konia. Wprowadź innego albo zarejestruj konia w Słowniki > Konie");
                }else{
                    Contestant c = new Contestant();
                    c.setClient(clientComboBoxModel.getSelectedClient());
                    c.setHorse(horseComboBoxModel.getSelectedHorse());
                    c.setCompetition(competitionComboBoxModel.getSelectedCompetition());
                    c.setContestantNumber();

                    contestantService.saveContestant(c);

                    JOptionPane.showMessageDialog(mainFrame, "Zapisano zawodnika");


                    clientNameTextField.setText(c.getClient().getName());
                    clientSurnameTextField.setText(c.getClient().getSurname());
                    horseNameTextField.setText(c.getHorse().getName());
                    competitionNameTextField.setText(c.getCompetition().getCompName());
                    contestantNumberTextField.setText(Integer.toString(c.getContestantNumber()));
 /*               }else{
                    JOptionPane.showMessageDialog(mainFrame, "Zawodnik został już zapisany na zawody");
                }*/

                }
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
        clientComboBoxModel = new ClientComboBoxModel(clientService.getAllClients());
        JComboBox<String> clients = new JComboBox<>(clientComboBoxModel);
        return clients;
    }

    private JComboBox<String> chooseHorseComboBox() {
        List<Horse> allHorseList = horseService.getAllHorses();
        List<Horse> horsesWithNoOwner = new ArrayList<>();
        for(Horse h : allHorseList){
            if(h.getOwner() == null){
                horsesWithNoOwner.add(h);
            }
        }
        horseComboBoxModel = new HorseComboBoxModel(horsesWithNoOwner);
        JComboBox<String> horses = new JComboBox<>(horseComboBoxModel);
        return horses;
    }

    private JComboBox<String> chooseCompetitionComboBox() {
        if(competitionService.getAllCompetitions().isEmpty() ){
            JOptionPane.showMessageDialog(mainFrame, "Brak zaplanowanych zawodów. Dodaj zawody w Słowniki > Zawody");
        }else {
            competitionComboBoxModel = new CompetitionComboBoxModel(competitionService.getAllCompetitions());
        }
        JComboBox<String> competitions = new JComboBox<>(competitionComboBoxModel);
        return competitions;
    }

}
