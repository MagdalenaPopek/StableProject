package pl.edu.pja.stable.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Magdalena on 2017-06-21.
 */
public class MainPanel extends JPanel {

    JScrollPane scrollPane;

    public MainPanel() {
        super(new BorderLayout());
        setOpaque(true);

        JEditorPane jep = new JEditorPane();
        jep.setEditable(false);

        // http://www.kurshtml.edu.pl/html/zielony.html
        StringBuffer sb = new StringBuffer();
        sb.append("<br><br><br>");
        sb.append("<b><p align='center'><font size='7' face='Verdana, Arial'>My Stable ver. 1.2</font></p></b>");
        sb.append("<br>");
        sb.append("<b><p align='center'><font size='5' face='Verdana, Arial'>Magdalena Popek</font></p></b>");
        sb.append("<br><br><br>");
        jep.setContentType("text/html");
        jep.setText(sb.toString());

        scrollPane = new JScrollPane(jep);

        //Add the text area to the content pane.
        add(scrollPane);
    }
}
