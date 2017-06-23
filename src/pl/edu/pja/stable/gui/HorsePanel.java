package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entityutils.HorseGender;
import pl.edu.pja.stable.model.HorseComboBoxModel;
import pl.edu.pja.stable.model.OwnerComboBoxModel;
import pl.edu.pja.stable.model.StallComboBoxModel;
import pl.edu.pja.stable.services.dao.HorseService;
import pl.edu.pja.stable.services.dao.OwnerService;
import pl.edu.pja.stable.services.dao.StallService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EnumSet;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class HorsePanel extends JPanel {

    JFrame mainFrame;
    HorseService horseService = new HorseService();
    OwnerService ownerService = new OwnerService();
    StallService stallService = new StallService();
    HorseComboBoxModel horseComboBoxModel;
    OwnerComboBoxModel ownerComboBoxModel;
    StallComboBoxModel stallComboBoxModel;

    public HorsePanel(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

        JComboBox<String> chooseHorseComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JTextField passportNumberTextField = new JTextField(columnSize);
        JComboBox<HorseGender> horseGenderJComboBox = new JComboBox<HorseGender>();
        JComboBox<String> ownerJComboBox = chooseOwnerComboBox();
        JComboBox<String> stallTextField = chooseStallComboBox();

        EnumSet<HorseGender> allHorseGender = EnumSet.allOf(HorseGender.class);
        for (HorseGender hg : allHorseGender) {
            horseGenderJComboBox.addItem(hg);
        }

        horseGenderJComboBox.setSelectedItem(null);

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz konia"), "");
        chooseHorseComboBox = chooseHorseComboBox();
        this.add(chooseHorseComboBox, "wrap 32");

        chooseHorseComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().equals("Nowy")) {
                    nameTextField.setText("");
                    nameTextField.setEnabled(true);
                    passportNumberTextField.setText("");
                    passportNumberTextField.setEnabled(true);
                    horseGenderJComboBox.setSelectedItem(null);
                    horseGenderJComboBox.setEnabled(true);
                    ownerJComboBox.setSelectedItem(null);
                    ownerJComboBox.setEnabled(true);
                    stallTextField.setSelectedItem(null);
                    stallTextField.setEnabled(true);
                    return;
                }

                //System.out.println(e.getItem().toString());
                Horse h = horseComboBoxModel.getSelectedHorse();
                nameTextField.setText(h.getName());
                nameTextField.setEnabled(false);
                passportNumberTextField.setText(h.getPassportNumber());
                passportNumberTextField.setEnabled(false);
                horseGenderJComboBox.setSelectedItem(h.getGender());
                horseGenderJComboBox.setEnabled(false);

                if (h.getOwner() != null) {
                    ownerComboBoxModel.setSelectedOwner(h.getOwner());
                    ownerJComboBox.updateUI();
                } else
                    ownerJComboBox.setSelectedItem(null);

                ownerJComboBox.setEnabled(false);

                stallComboBoxModel.setSelectedStall(h.getStall());
                ownerJComboBox.updateUI();
                stallTextField.setEnabled(false);
            }
        });


        this.add(new JLabel("Nazwa:"), "");
        this.add(nameTextField, "wrap");
        this.add(new JLabel("Numer paszportu:"), "");
        this.add(passportNumberTextField, "wrap");
        this.add(new JLabel("Płeć:"), "");
        this.add(horseGenderJComboBox, "wrap");
        this.add(new JLabel("Właściciel:"), "");
        this.add(ownerJComboBox, "wrap 32");
        this.add(new JLabel("Nr boksu:"), "");
        this.add(stallTextField, "wrap 32");


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

        jButtonCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseHorseComboBox.getSelectedItem().equals("Nowy")) {
                    if(stallComboBoxModel.getSelectedStall().getHorse() == null) {
                    System.out.println("Dodaję nowego konia...");
                    Horse h = new Horse();
                    h.setName(nameTextField.getText());
                    h.setPassportNumber(passportNumberTextField.getText());
                    h.setGender((HorseGender) horseGenderJComboBox.getSelectedItem());
                    if (ownerComboBoxModel.getSelectedItem() == null) {
                        h.setOwner(null);
                    } else {
                        h.setOwner(ownerComboBoxModel.getSelectedOwner());
                    }

                        h.setStall(stallComboBoxModel.getSelectedStall());
                        stallComboBoxModel.getSelectedStall().setHorse(h);

                    horseService.saveHorse(h);

                    horseComboBoxModel.addHorse(h);
                    chooseHorseComboBox.updateUI();
                    chooseHorseComboBox.setSelectedIndex(chooseHorseComboBox.getItemCount() - 1);
                    }else{
                        JOptionPane.showMessageDialog(mainFrame, "Ten boks jest zajęty, wybierz inny");
                    }
                }
            }
        });

        buttonPanel.add(jButtonCommit);
        buttonPanel.add(jButtonExit);

        this.add(new JTextArea());
        this.add(buttonPanel);
    }

    private JComboBox<String> chooseHorseComboBox() {
        horseComboBoxModel = new HorseComboBoxModel(horseService.getAllHorses());
        JComboBox<String> horses = new JComboBox<>(horseComboBoxModel);
        return horses;
    }

    private JComboBox<String> chooseOwnerComboBox() {
        ownerComboBoxModel = new OwnerComboBoxModel(ownerService.getAllOwners(), true);
        JComboBox<String> owner = new JComboBox<>(ownerComboBoxModel);
        return owner;
    }

    private JComboBox<String> chooseStallComboBox() {
        stallComboBoxModel = new StallComboBoxModel(stallService.getAllStalls(), true);
        JComboBox<String> stall = new JComboBox<>(stallComboBoxModel);
        return stall;
    }

}