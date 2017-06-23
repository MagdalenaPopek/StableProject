package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import org.hibernate.PropertyValueException;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.entityutils.CompetitionCategory;
import pl.edu.pja.stable.entityutils.CompetitionLevel;
import pl.edu.pja.stable.entityutils.CompetitionType;
import pl.edu.pja.stable.model.CompetitionComboBoxModel;
import pl.edu.pja.stable.services.dao.CompetitionService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

        //DODAJĘ POLA
        JComboBox<String> chooseCompetitionComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JComboBox<CompetitionLevel> competitionLevelJComboBox = new JComboBox<CompetitionLevel>();
        JComboBox<CompetitionCategory> competitionCategoryJComboBox = new JComboBox<CompetitionCategory>();
        JTextField prizeTextField = new JTextField(columnSize);
        JComboBox<CompetitionType> competitionTypeJComboBox = new JComboBox<CompetitionType>();
        JCheckBox competitionTookPlaceCheckBox = new JCheckBox();
        competitionTookPlaceCheckBox.setEnabled(false);

        //UZUPELNIAM ENUM
        EnumSet<CompetitionLevel> allCompetitionLevels = EnumSet.allOf(CompetitionLevel.class);
        for (CompetitionLevel cl : allCompetitionLevels) {
            competitionLevelJComboBox.addItem(cl);
        }

        EnumSet<CompetitionCategory> allCompetitionCategories = EnumSet.allOf(CompetitionCategory.class);
        for (CompetitionCategory cc : allCompetitionCategories) {
            competitionCategoryJComboBox.addItem(cc);
        }

        EnumSet<CompetitionType> allCompetitionTypes = EnumSet.allOf(CompetitionType.class);
        for (CompetitionType ct : allCompetitionTypes) {
            competitionTypeJComboBox.addItem(ct);
        }

        //USTAWIAM SELECTED ITEM W COMBOBOXACH ENUMÓW NA NULL
        competitionLevelJComboBox.setSelectedItem(null);
        competitionCategoryJComboBox.setSelectedItem(null);
        competitionTypeJComboBox.setSelectedItem(null);

        //
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

                    competitionTookPlaceCheckBox.setSelected(false);
                    competitionTookPlaceCheckBox.setEnabled(false);
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

                if(c.isTookPlace()) {
                    competitionTookPlaceCheckBox.setSelected(true);
                }else{
                    competitionTookPlaceCheckBox.setSelected(false);
                }
                competitionTookPlaceCheckBox.setEnabled(false);
            }
        });

        this.add(new JLabel("Nazwa:"), "");
        this.add(nameTextField, "wrap");

        this.add(new JLabel("Poziom:"), "");
        this.add(competitionLevelJComboBox, "wrap");
        this.add(new JLabel("Kategoria:"), "");
        this.add(competitionCategoryJComboBox, "wrap");
        this.add(new JLabel("Nagroda:"), "");
        this.add(prizeTextField, "wrap");
        this.add(new JLabel("Rodzaj zawodów:"), "");
        this.add(competitionTypeJComboBox, "wrap");
        this.add(new JLabel("Czy się odbyły:"), "");
        this.add(competitionTookPlaceCheckBox, "wrap");

        JPanel buttonPanel = new JPanel();
        JButton jButtonCommit = new JButton("Zatwierdź");
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new MainPanel());
                mainFrame.pack();
            }
        });

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseCompetitionComboBox.getSelectedItem().equals("Nowy")) {
                    try {
//                        System.out.println("Dodaję nowe zawody...");
                        Competition c = new Competition();
                        c.setCompName(nameTextField.getText());
                        c.setCompetitionLevel((CompetitionLevel) competitionLevelJComboBox.getSelectedItem());
                        c.setCompetitionCategory((CompetitionCategory) competitionCategoryJComboBox.getSelectedItem());

                        c.setPrize(Double.parseDouble(prizeTextField.getText()));
                        c.setCompetitionType((CompetitionType) competitionTypeJComboBox.getSelectedItem());
                        c.setTookPlace(false);

                        competitionService.saveCompetition(c);

                        competitionComboBoxModel.addCompetition(c);
                        chooseCompetitionComboBox.updateUI();
                        chooseCompetitionComboBox.setSelectedIndex(chooseCompetitionComboBox.getItemCount() - 1);
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(mainFrame, "Nagroda musi przyjmować wartość liczbową");
                    }catch (PropertyValueException p){
                        JOptionPane.showMessageDialog(mainFrame, "Wszystkie pola muszą zostać wypełnione");
                    }

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
