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
 * Created by artur.popek on 2017-06-16.
 */
public class StableFrame extends JFrame

{
    JFrame mainFrame;

    public StableFrame() {
        super("MyStable");
        setMinimumSize(new Dimension(200, 200));

        mainFrame = this;

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



     private void createTest(){

        String cc = "";
        add(createButton(null), cc);
        add(createButton("square"), cc);
        add(createButton("gradient"), cc);
        add(createButton("bevel"), cc);
        add(createButton("textured"), cc);
        add(createButton("roundRect"), cc);
        add(createButton("recessed"), cc);
        add(createButton("help"), cc);

        add(createIconButton(null), cc + ", newline");
        add(createIconButton("square"), cc);
        add(createIconButton("gradient"), cc);
        add(createIconButton("bevel"), cc);
        add(createIconButton("textured"), cc);
        add(createIconButton("roundRect"), cc);
        add(createIconButton("recessed"), cc);
        add(createIconButton("help"), cc);

        add(createToggleButton(null), cc + ", newline");
        add(createToggleButton("square"), cc);
        add(createToggleButton("gradient"), cc);
        add(createToggleButton("bevel"), cc);
        add(createToggleButton("textured"), cc);
        add(createToggleButton("roundRect"), cc);
        add(createToggleButton("recessed"), cc);
        add(createToggleButton("help"), cc);

        add(createBorderButton("button", null), cc + ", newline");
        add(createBorderButton("button", new LineBorder(Color.BLACK)), cc);
        add(createBorderButton("button", new MatteBorder(3, 3, 3, 3, Color.BLACK)), cc);

        add(createCombo("JComboBox.isPopDown", false), cc + ", newline");
        add(createCombo("JComboBox.isSquare", false), cc);
        add(createCombo(null, false), "");

        add(createCombo("JComboBox.isPopDown", true), cc + ", newline");
        add(createCombo("JComboBox.isSquare", true), cc);
        add(createCombo(null, true), cc);

        JTextField ta = new JTextField("No Border");
        ta.setBorder(new EmptyBorder(0, 0, 0, 0));
        add(ta, cc + ", newline");
        JTextField tfo = new JTextField("Opaque");
        tfo.setOpaque(true);
        add(tfo, cc);
        add(new JTextArea("A text"), cc);
        add(new JTextField("A text"), cc);
        add(new JScrollPane(new JTextPane()), cc);
        add(new JScrollPane(new JTextArea("A text", 1, 20)), cc);
        JList list = new JList(new Object[] {"A text"});
        list.setVisibleRowCount(1);
        add(new JScrollPane(list), cc);

        add(new JTextField("Compared to"), cc + ", newline");
        add(new JSpinner(new SpinnerNumberModel(1, 1, 10000, 1)), cc);
        add(new JSpinner(new SpinnerDateModel()), cc);
        add(new JSpinner(new SpinnerListModel(new Object[]{"One", "Two", "Fifteen"})), cc);
        JSpinner spinner = new JSpinner();
        spinner.setEditor(new JTextField());
        add(spinner, cc);

        add(createToggle("toggle", null, true, new EmptyBorder(0, 0, 0, 0)), cc + ", newline");
        add(createToggle("toggle", null, true, null), cc);
        add(createToggle("toggle", "regular", true, null), cc);
        add(createToggle("toggle", "small", true, null), cc);
        add(createToggle("toggle", "mini", true, null), cc);
        add(createToggle("toggle", null, false, new EmptyBorder(0, 0, 0, 0)), cc);
        add(createToggle("toggle", null, false, null), cc);
        add(createToggle("toggle", "regular", false, null), cc);
        add(createToggle("toggle", "small", false, null), cc);
        add(createToggle("toggle", "mini", false, null), cc);

        add(createTabbedPane(), cc + ", newline, growx");

        pack();
        setLocationRelativeTo(null);
    }

    private JToggleButton createToggle(String name, String size, boolean radio, Border border)
    {
        JToggleButton button = radio ? new JRadioButton(name) : new JCheckBox(name);
        if (size != null)
            button.putClientProperty("JComponent.sizeVariant", size);
        button.setFocusable(false);

        if (border != null)
            button.setBorder(border);

        return button;
    }

    private JButton createButton(String type)
    {
        String name = String.valueOf(type);
        if (name.equals("help"))
            name = "";
        JButton button = new JButton(name);
        button.setDefaultCapable(false);
        button.setFocusable(false);
        if (type != null && type.equals("...") == false)
            button.putClientProperty("JButton.buttonType", type);
        return button;
    }

    private JButton createIconButton(String type)
    {
        String name = String.valueOf(type);
        if (name.equals("help"))
            name = "";
        JButton button = new JButton(name);
        button.setIcon(new ImageIcon(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB)));
        button.setDefaultCapable(false);
        button.setFocusable(false);
        if (type != null && type.equals("...") == false)
            button.putClientProperty("JButton.buttonType", type);
        return button;
    }

    private JToggleButton createToggleButton(String type)
    {
        String name = String.valueOf(type);
        if (name.equals("help"))
            name = "";
        JToggleButton button = new JToggleButton(name);
        button.setFocusable(false);
        if (type != null)
            button.putClientProperty("JButton.buttonType", type);
        return button;
    }

    private JButton createBorderButton(String name, Border border)
    {
        JButton button = new JButton(name);
        button.setDefaultCapable(false);
        button.setFocusable(false);
        button.setBorder(border);
        return button;
    }

    private JComboBox createCombo(String key, boolean editable)
    {
        JComboBox comboBox = new JComboBox(new Object[]{ String.valueOf(key)});
        comboBox.setFocusable(editable);
        comboBox.setEditable(editable);
        if (key != null)
            comboBox.putClientProperty(key, Boolean.TRUE);
        return comboBox;
    }

    private JTabbedPane createTabbedPane()
    {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("tab1", new JLabel("tab1"));
        tabbedPane.addTab("tab2", new JLabel("tab2"));
        return tabbedPane;
    }

    private JPanel addClientAndHorsePanel(){
        return new ClientAndHorsePanel();
    }

    public static void main(String args[])
    {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }


        StableFrame stableFrame = new StableFrame();
        stableFrame.setVisible(true);
    }
}