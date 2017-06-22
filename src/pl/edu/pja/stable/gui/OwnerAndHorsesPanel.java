package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entity.Owner;
import pl.edu.pja.stable.entityutils.CompetitionLevel;
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
import java.util.Set;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class OwnerAndHorsesPanel extends JPanel {

    JFrame mainFrame;
    HorseService horseService = new HorseService();
    OwnerService ownerService = new OwnerService();
    HorseComboBoxModel horseComboBoxModel;
    OwnerComboBoxModel ownerComboBoxModel;

    public OwnerAndHorsesPanel(JFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;

        JComboBox<String> chooseOwnerComboBox;
        JComboBox<String> horseComboBox;

        int columnSize = 32;
        JTextField nameTextField = new JTextField(columnSize);
        JTextField passportNumberTextField = new JTextField(columnSize);
        JComboBox<String> ownerJComboBox = chooseOwnerComboBox();

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        this.add(new JLabel("Wybierz właściciela"), "");
        chooseOwnerComboBox = chooseOwnerComboBox();
        this.add(chooseOwnerComboBox, "wrap 32");

        this.add(new JLabel("Wybierz konia"), "");
        horseComboBox = chooseHorseComboBox();
        this.add(horseComboBox, "wrap 32");

        chooseOwnerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Owner o = ownerComboBoxModel.getSelectedOwner();
                ownerJComboBox.updateUI();
            }
        });

        horseComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Horse h = horseComboBoxModel.getSelectedHorse();
                nameTextField.setText(h.getName());
                nameTextField.setEnabled(false);
                passportNumberTextField.setText(h.getPassportNumber());
                passportNumberTextField.setEnabled(false);

                ownerComboBoxModel.setSelectedOwner(h.getOwner());
                ownerJComboBox.updateUI();
                ownerJComboBox.setEnabled(false);

                ownerJComboBox.updateUI();

            }
        });


        this.add(new JLabel("Nazwa:"), "");
        this.add(nameTextField, "wrap");
        this.add(new JLabel("Numer paszportu:"), "");
        this.add(passportNumberTextField, "wrap");
        this.add(new JLabel("Właściciel:"), "");
        this.add(ownerJComboBox, "wrap 32");


        JPanel buttonPanel = new JPanel();
        JButton jButtonExit = new JButton("Wyjdź");

        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new AboutPanel());
                mainFrame.pack();
            }
        });

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


}