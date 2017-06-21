package pl.edu.pja.stable.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Created by Magdalena on 2017-06-16.
 */
public class StableFrame extends JFrame
{
    JFrame mainFrame;
    JTextArea defaultTextArea;
    JScrollPane scrollPane;


    public StableFrame() {
        super("MyStable");
        mainFrame = this;

        setMinimumSize(new Dimension(200, 200));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setLayout(new MigLayout("nogrid, debug"));
        setLayout(new MigLayout("wrap"));

        //add menubar to the frame
        setJMenuBar(new MainMenu());
        setContentPane(createContentPane());

        //add(addClientAndHorsePanel());

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }


    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        JEditorPane jep = new JEditorPane();
        jep.setEditable(false);

        //TODO
        //Należy stworzyć prostą stronę w HTML'u !!!! jako stronę wyświetlającą informacje o programie
        try {
            jep.setPage("http://www.99lime.com/_bak/topics/html-is-easy/");
        }catch (IOException e) {
            jep.setContentType("text/html");
            jep.setText("<html>Could not load</html>");
        }
        scrollPane = new JScrollPane(jep);

        //Add the text area to the content pane.
        contentPane.add(scrollPane);

        return contentPane;
    }



    private JPanel addClientAndHorsePanel() {
        return new ClientPanel();
    }

    public static void main(String args[]) {
        StableFrame stableFrame = new StableFrame();
        stableFrame.setVisible(true);
    }
}