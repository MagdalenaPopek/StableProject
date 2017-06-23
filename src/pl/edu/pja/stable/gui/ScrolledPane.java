package pl.edu.pja.stable.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Magdalena on 2017-06-23.
 */
public class ScrolledPane extends JPanel{

    private JScrollPane vertical;
    private JFrame mainFrame;

    public ScrolledPane()
    {
        setPreferredSize(new Dimension(200, 250));

        vertical = new JScrollPane(mainFrame);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(vertical);
    }


    public static void main( String args[] )
    {
        new JFrame()
        {{
            getContentPane().add(new ScrolledPane());
            pack();
            setVisible(true);
        }};
    }
}