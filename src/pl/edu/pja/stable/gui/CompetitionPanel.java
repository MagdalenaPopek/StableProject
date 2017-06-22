package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entityutils.CompetitionCategory;
import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;
import pl.edu.pja.stable.entityutils.HorseGender;
import pl.edu.pja.stable.model.CompetitionComboBoxModel;
import pl.edu.pja.stable.model.HorseComboBoxModel;
import pl.edu.pja.stable.model.OwnerComboBoxModel;
import pl.edu.pja.stable.model.StallComboBoxModel;
import pl.edu.pja.stable.services.dao.CompetitionService;
import pl.edu.pja.stable.services.dao.HorseService;
import pl.edu.pja.stable.services.dao.OwnerService;
import pl.edu.pja.stable.services.dao.StallService;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.EnumSet;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class CompetitionPanel extends JPanel {

    JFrame mainFrame;
    CompetitionService competitionService = new CompetitionService();
    CompetitionComboBoxModel competitionComboBoxModel;

    public CompetitionPanel(JFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        JComboBox<String> chooseCompetitionComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JComboBox<CompetitionLevel> competitionLevelJComboBox = new JComboBox<CompetitionLevel>();
        JComboBox<CompetitionCategory> competitionCategoryJComboBox = new JComboBox<CompetitionCategory>();
//        JTextField prizeTextField = new JTextField(columnSize);
        JFormattedTextField prizeTextField = new JFormattedTextField(formatter);
        prizeTextField.setColumns(columnSize);
        JComboBox<CompetitionType> competitionTypeJComboBox = new JComboBox<CompetitionType>();

        EnumSet<CompetitionLevel> allCompetitionLevels = EnumSet.allOf(CompetitionLevel.class );
        for(CompetitionLevel cl : allCompetitionLevels) {
            competitionLevelJComboBox.addItem(cl);
        }

        EnumSet<CompetitionCategory> allCompetitionCategories = EnumSet.allOf(CompetitionCategory.class );
        for(CompetitionCategory cc : allCompetitionCategories) {
            competitionCategoryJComboBox.addItem(cc);
        }

        EnumSet<CompetitionType> allCompetitionTypes = EnumSet.allOf(CompetitionType.class );
        for(CompetitionType ct : allCompetitionTypes) {
            competitionTypeJComboBox.addItem(ct);
        }

        competitionLevelJComboBox.setSelectedItem(null);
        competitionCategoryJComboBox.setSelectedItem(null);
        competitionTypeJComboBox.setSelectedItem(null);



        this.add(new JLabel("Wybierz zawody"), "");
        chooseCompetitionComboBox = chooseCompetitionComboBox();
        this.add(chooseCompetitionComboBox, "wrap 32");

        chooseCompetitionComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().equals("Nowy")) {

                    nameTextField.setText("");
                    nameTextField.setEnabled(true);

                    competitionLevelJComboBox.setSelectedItem(null);
                    competitionLevelJComboBox.setEnabled(true);

                    competitionCategoryJComboBox.setSelectedItem(null);
                    competitionCategoryJComboBox.setEnabled(true);

                    prizeTextField.setText("");
                    prizeTextField.setEnabled(true);

                    competitionTypeJComboBox.setSelectedItem(null);
                    competitionTypeJComboBox.setEnabled(true);
                    return;
                }

                //System.out.println(e.getItem().toString());
                Competition c = competitionComboBoxModel.getSelectedCompetition();

                nameTextField.setText(c.getCompName());
                nameTextField.setEnabled(false);

                competitionLevelJComboBox.setSelectedItem(c.getCompetitionLevel());
                competitionLevelJComboBox.setEnabled(false);

                competitionCategoryJComboBox.setSelectedItem(c.getCompetitionCategory());
                competitionCategoryJComboBox.setEnabled(false);

                prizeTextField.setText(String.valueOf(c.getPrize()));
                prizeTextField.setEnabled(false);

                competitionTypeJComboBox.setSelectedItem(c.getCompetitionType());
                competitionTypeJComboBox.setEnabled(false);
            }
        });

        nameTextField.setText("To jest test");
        //JTextField nameTextField1 = new JTextField("");
        this.add(new JLabel("Nazwa:"),"");
        this.add(nameTextField, "wrap");

        //nameTextField = new JTextField("");
        //this.add(new JLabel("Nazwa:"),"");
        //this.add(nameTextField, "wrap");

        this.add(new JLabel("Poziom:"), "");
        this.add(competitionLevelJComboBox, "wrap");
        this.add(new JLabel("Kategoria:"), "");
        this.add(competitionCategoryJComboBox, "wrap");
        this.add(new JLabel("Nagroda:"), "");
        this.add(prizeTextField, "wrap");
        this.add(new JLabel("Rodzaj zawodów:"), "");
        this.add(competitionTypeJComboBox, "wrap");

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(e -> {
            mainFrame.setContentPane(new AboutPanel());
            mainFrame.pack();
        });

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseCompetitionComboBox.getSelectedItem().equals("Nowy")) {
                    System.out.println("Dodaję nowe zawody...");
                    Competition c = new Competition();
                    c.setCompName(nameTextField.getText());
                    c.setCompetitionLevel((CompetitionLevel) competitionLevelJComboBox.getSelectedItem());
                    c.setCompetitionCategory((CompetitionCategory) competitionCategoryJComboBox.getSelectedItem());
                    c.setPrize(Double.parseDouble(prizeTextField.getText()));
                    c.setCompetitionType((CompetitionType) competitionTypeJComboBox.getSelectedItem());

                    competitionService.saveCompetition(c);

                    competitionComboBoxModel.addCompetition(c);
                    chooseCompetitionComboBox.updateUI();
                    chooseCompetitionComboBox.setSelectedIndex(chooseCompetitionComboBox.getItemCount() - 1);
                }
            }
        });

        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseCompetitionComboBox() {
        competitionComboBoxModel = new CompetitionComboBoxModel(competitionService.getAllCompetitions());
        JComboBox<String> competitions = new JComboBox<>(competitionComboBoxModel);
        return competitions;
    }
}
