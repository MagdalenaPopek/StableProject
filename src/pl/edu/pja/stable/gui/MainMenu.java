package pl.edu.pja.stable.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class MainMenu extends JMenuBar {

    JFrame mainFrame;

    public MainMenu(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

        //Najgłówniejsze menu
        JMenu dictionaryMenu = new JMenu("Słowniki");
        JMenu competitionMenu = new JMenu("Zawody");
        final JMenu systemMenu = new JMenu("System");

        //Podmenu Słowniki
        JMenuItem clientsMnuItm = new JMenuItem("Klienci");
        JMenuItem ownersMnuItm = new JMenuItem("Właściciele");
        JMenuItem horsesMnuItm = new JMenuItem("Konie");
        JMenuItem competitionMnuItm = new JMenuItem("Zawody");
        JMenu showListMnu = new JMenu("Wyświetl powiązania");
        JMenuItem showOwnersAndHorsesMnuItem = new JMenuItem("Właściciele i konie");

        dictionaryMenu.add(clientsMnuItm);
        dictionaryMenu.add(ownersMnuItm);
        dictionaryMenu.add(horsesMnuItm);
        dictionaryMenu.add(competitionMnuItm);
        dictionaryMenu.addSeparator();
        dictionaryMenu.add(showListMnu);
        showListMnu.add(showOwnersAndHorsesMnuItem);

        //Podmenu Zawody
        JMenu addToCompetitionMnu = new JMenu("Dodaj do zawodów");
        JMenuItem addClientToCompetitionMnuItm = new JMenuItem("Klienta");

        competitionMenu.add(addToCompetitionMnu);
        addToCompetitionMnu.add(addClientToCompetitionMnuItm);

        //Podmenu O programie
        JMenuItem exitMnuItm = new JMenuItem("Wyjście z systemu");
        systemMenu.add(exitMnuItm);

        /**
         * Przejdź do dodawania klienta
         */
        clientsMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new ClientPanel(mainFrame));
                mainFrame.pack();
            }
        });

        /**
         * Przejdź do dodawania właściciela
         */
        ownersMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new OwnerPanel(mainFrame));
                mainFrame.pack();
            }
        });

        /**
         * Przejdź do dodawania konia
         */
        horsesMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new HorsePanel(mainFrame));
                mainFrame.pack();
            }
        });

        /**
         * Przejdź do dodawania zawodów
         */
        competitionMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new CompetitionPanel(mainFrame));
                mainFrame.pack();
            }
        });

        /**
         * Przejdź do wyświetlania klientów i koni
         */
        showOwnersAndHorsesMnuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new OwnerAndHorsesPanel(mainFrame));
                mainFrame.pack();
            }
        });


        /**
         * Przejdź do dodawania klienta do zawodów
         */
        addClientToCompetitionMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new ClientHorseCompPanel(mainFrame));
                mainFrame.pack();
            }
        });


        exitMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int choose = JOptionPane.showConfirmDialog(mainFrame, "Czy na pewno chcesz opuścić\n"
                        + "taki fajny i przydatny program?\n"
                        + "       Jesteś pewien?", "Wyjście", JOptionPane.YES_NO_OPTION);

                if (choose == JOptionPane.YES_OPTION)
                    System.exit(0);
                else
                    return;
            }
        });

        //add menu to menubar
        this.add(dictionaryMenu);
        this.add(competitionMenu);
        this.add(systemMenu);
    }
}
