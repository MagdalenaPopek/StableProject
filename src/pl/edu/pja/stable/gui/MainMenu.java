package pl.edu.pja.stable.gui;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by artur.popek on 2017-06-16.
 */
public class MainMenu extends JMenuBar{

    JMenuBar menuBar;


    public MainMenu(){
        super();

        menuBar = this;
        //create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        final JMenu aboutMenu = new JMenu("About");

        //create menu items
        JMenu newMenu = new JMenu("New");
        newMenu.setMnemonic(KeyEvent.VK_N);
        //newMenu.setActionCommand("New");

        JMenuItem existingUserMI = new JMenuItem("Existing user");
        JMenu newUserMI = new JMenu("New user");
        JMenuItem withHorseMI = new JMenuItem("With Horse");
        newMenu.setActionCommand("?");
        JMenuItem noHorseMI = new JMenuItem("Without Horse");
        newMenu.setActionCommand("?");
        newMenu.add(existingUserMI);
        newMenu.add(newUserMI);
        newUserMI.add(withHorseMI);
        newUserMI.add(noHorseMI);


        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setActionCommand("Open");

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setActionCommand("Save");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.setActionCommand("Cut");

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.setActionCommand("Copy");

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.setActionCommand("Paste");

        MainMenu.MenuItemListener menuItemListener = new MainMenu.MenuItemListener();

        newMenu.addActionListener(menuItemListener);
        openMenuItem.addActionListener(menuItemListener);
        saveMenuItem.addActionListener(menuItemListener);
        exitMenuItem.addActionListener(menuItemListener);
        cutMenuItem.addActionListener(menuItemListener);
        copyMenuItem.addActionListener(menuItemListener);
        pasteMenuItem.addActionListener(menuItemListener);

        final JCheckBoxMenuItem showWindowMenu = new JCheckBoxMenuItem(
                "Show About", true);
        showWindowMenu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                if(showWindowMenu.getState()){
                    menuBar.add(aboutMenu);
                } else {
                    menuBar.remove(aboutMenu);
                }
            }
        });

        //add menu items to menus
        fileMenu.add(newMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(showWindowMenu);

        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        //add menu to menubar
        this.add(fileMenu);
        this.add(editMenu);
        this.add(aboutMenu);
    }

    class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO
        }
    }
}
