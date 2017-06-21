package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Magdalena on 2017-06-16.
 */
public class StableFrame extends JFrame {
    JFrame mainFrame;
    JTextArea defaultTextArea;

    public StableFrame() {
        super("MyStable");
        mainFrame = this;

        setMinimumSize(new Dimension(400, 400));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setLayout(new MigLayout("nogrid, debug"));
        setLayout(new MigLayout("wrap"));

        //add menubar to the frame
        setJMenuBar(new MainMenu(this));
        setContentPane(new AboutPanel());

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

}