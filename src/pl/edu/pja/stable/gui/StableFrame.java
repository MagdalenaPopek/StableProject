package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import net.miginfocom.swing.MigLayout;


/**
 * Created by Magdalena on 2017-06-16.
 */
public class StableFrame extends JFrame
{
    JFrame mainFrame;

    public StableFrame() {
        super("MyStable");
        mainFrame = this;

        setMinimumSize(new Dimension(200, 200));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setLayout(new MigLayout("nogrid, debug"));
        setLayout(new MigLayout("wrap"));

        //add menubar to the frame
        setJMenuBar(new MainMenu());
        setVisible(true);
        add(addClientAndHorsePanel());

        pack();
        setLocationRelativeTo(null);
    }


    private JPanel addClientAndHorsePanel() {
        return new ClientAndHorsePanel();
    }

    public static void main(String args[]) {
        StableFrame stableFrame = new StableFrame();
        stableFrame.setVisible(true);
    }
}