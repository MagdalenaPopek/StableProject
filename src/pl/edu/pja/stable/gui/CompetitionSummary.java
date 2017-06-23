package pl.edu.pja.stable.gui;

import pl.edu.pja.stable.model.ClientComboBoxModel;
import pl.edu.pja.stable.services.dao.ClientService;

import javax.swing.*;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class CompetitionSummary extends JPanel {

    JFrame mainFrame;
    ClientService service = new ClientService();
    ClientComboBoxModel clientComboBoxModel;

    public CompetitionSummary(JFrame mainFrame) {
        super();

        this.mainFrame = mainFrame;

    }
}
