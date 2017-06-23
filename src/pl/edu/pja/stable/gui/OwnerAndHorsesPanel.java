package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entity.Owner;
import pl.edu.pja.stable.model.HorseComboBoxModel;
import pl.edu.pja.stable.model.OwnerComboBoxModel;
import pl.edu.pja.stable.services.dao.HorseService;
import pl.edu.pja.stable.services.dao.OwnerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class OwnerAndHorsesPanel extends JPanel {

    JFrame mainFrame;
    HorseService horseService = new HorseService();
    OwnerService ownerService = new OwnerService();
    HorseComboBoxModel horseComboBoxModel;
    OwnerComboBoxModel ownerComboBoxModel;

    JComboBox<String> chooseOwnerComboBox = chooseOwnerComboBox();
    JComboBox<String> chooseHorseComboBox = chooseHorseComboBox();


    public OwnerAndHorsesPanel(JFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;

        MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
        this.setLayout(layout);

        int columnSize = 32;

        JTextArea horsesTextArea = new JTextArea(5, columnSize);
        JTextField nameTextField = new JTextField(columnSize);
        JTextField passportNumberTextField = new JTextField(columnSize);
        JTextField ownerTextField = new JTextField(columnSize);
        nameTextField.setEnabled(false);
        passportNumberTextField.setEnabled(false);
        ownerTextField.setEnabled(false);
        horsesTextArea.setFont(horsesTextArea.getFont().deriveFont(12f));

        this.add(new JLabel("Wybierz właściciela"), "");
        this.add(chooseOwnerComboBox, "wrap 32");
        this.add(new JLabel("Lista posiadanych koni:"), "");
        this.add(horsesTextArea, "wrap 32");

        this.add(new JLabel("Wybierz konia"), "");
        this.add(chooseHorseComboBox, "wrap 32");
        chooseHorseComboBox.setSelectedItem(null);

        //Wybieram właściciela
        chooseOwnerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Owner o = ownerComboBoxModel.getSelectedOwner();
              //  ownerTextField.setText(o.getName() + " " + o.getSurname());

                horsesTextArea.setText("");
                horsesTextArea.setRows(ownerComboBoxModel.getSelectedOwner().getHorses().size());
                for (Horse h : ownerComboBoxModel.getSelectedOwner().getHorses()) {
                    horsesTextArea.append("Nazwa:\t" + h.getName() + "\t Płeć: " + h.getGender() + "\tPaszport nr: " + h.getPassportNumber() + "\n");
                }
                horseComboBoxModel = new HorseComboBoxModel(ownerComboBoxModel.getSelectedOwner().getHorses(), true);
                chooseHorseComboBox.setModel(horseComboBoxModel);

                nameTextField.setText("");
                passportNumberTextField.setText("");
            }
        });


        //TUTAJ Z KLIKNIĘTEGO KONIA WYBIERAM DANE DO PÓL
        chooseHorseComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Horse h = horseComboBoxModel.getSelectedHorse();
                nameTextField.setText(h.getName());
                passportNumberTextField.setText(h.getPassportNumber());
                ownerTextField.setText(h.getOwner().getName() + " " + h.getOwner().getSurname());
            }
        });


        this.add(new JLabel("Nazwa:"), "");
        this.add(nameTextField, "wrap");
        this.add(new JLabel("Numer paszportu:"), "");
        this.add(passportNumberTextField, "wrap");
        this.add(new JLabel("Właściciel:"), "");
        this.add(ownerTextField, "wrap 32");


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


    private JComboBox<String> chooseOwnerComboBox() {
        ownerComboBoxModel = new OwnerComboBoxModel(ownerService.getAllOwners(), true);
        JComboBox<String> owner = new JComboBox<>(ownerComboBoxModel);
        return owner;
    }

    private JComboBox<String> chooseHorseComboBox() {
        horseComboBoxModel = new HorseComboBoxModel(ownerComboBoxModel.getSelectedOwner().getHorses(), true);
        JComboBox<String> horses = new JComboBox<>(horseComboBoxModel);
        return horses;
    }

    private void refreshHorseComboBox() {
        horseComboBoxModel.setOnlyHorse(true);
        horseComboBoxModel.refresh(ownerComboBoxModel.getSelectedOwner().getHorses());
    }
}