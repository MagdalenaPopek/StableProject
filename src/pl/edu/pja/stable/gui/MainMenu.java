package pl.edu.pja.stable.gui;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class MainMenu extends JMenuBar{

    JMenuBar menuBar;


    public MainMenu(){
        super();

        menuBar = this;
        //create menus
        JMenu dictionaryMenu = new JMenu("Słowniki");
        JMenu competitionMenu = new JMenu("Zawody");
        final JMenu aboutMenu = new JMenu("O programie");

        JMenuItem clientsMnu = new JMenuItem("Klienci");
        JMenuItem ownersMnu = new JMenuItem("Właściciele");
        JMenuItem horsesMnu = new JMenuItem("Konie");
        JMenuItem employeeMnu = new JMenuItem("Pracownicy");

        dictionaryMenu.add(clientsMnu);
        dictionaryMenu.add(ownersMnu);
        dictionaryMenu.add(horsesMnu);
        dictionaryMenu.addSeparator();
        dictionaryMenu.add(employeeMnu);

        clientsMnu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Klienci MNU");
            }
        });


        JMenuItem addToCompetitionMnu = new JMenuItem("Dodaj do zawodów");
        competitionMenu.add(addToCompetitionMnu);

        //add menu to menubar
        this.add(dictionaryMenu);
        this.add(competitionMenu);
        this.add(aboutMenu);
    }

    class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
}
