package com.konrad.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

public class WindowView	{

    /**
     * @wbp.parser.entryPoint
     */
    public static void windowViewMethod() {
        if (true) {
            try {
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() { 	

                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(new Color(panel.getBackground().getRGB()));
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SpringLayout sl_panel = new SpringLayout();
                panel.setLayout(sl_panel);

                JFrame frame = new JFrame();
                frame.setAutoRequestFocus(false);
                SpringLayout springLayout = new SpringLayout();
                springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.WEST, panel, 964, SpringLayout.WEST, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.SOUTH, panel, 562, SpringLayout.NORTH, frame.getContentPane());
                frame.getContentPane().setLayout(springLayout);
                frame.getContentPane().add(panel);
                JLabel background=new JLabel(new ImageIcon("C:\\Users\\Konrad\\Desktop\\aaa.png"));
                frame.getContentPane().add(background);
                background.setOpaque(true);

                
                JMenuBar menuBar = new JMenuBar();
                menuBar.setToolTipText("Menu");
                springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.SOUTH, menuBar, 21, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.EAST, menuBar, 97, SpringLayout.WEST, frame.getContentPane());
                frame.getContentPane().add(menuBar);
                
                JMenu fileMenu = new JMenu("File");
                menuBar.add(fileMenu);
                JMenuItem newAction = new JMenuItem("New");
                JMenuItem openAction = new JMenuItem("Open");
                JMenuItem exitAction = new JMenuItem("Exit");
                JMenuItem cutAction = new JMenuItem("Cut");
                JMenuItem copyAction = new JMenuItem("Copy");
                JMenuItem pasteAction = new JMenuItem("Paste");
                
                fileMenu.add(newAction);
                fileMenu.add(openAction);
                fileMenu.add(exitAction);
                fileMenu.add(cutAction);
                fileMenu.add(copyAction);
                fileMenu.add(pasteAction);
                
                
                frame.setSize(1000, 600);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
