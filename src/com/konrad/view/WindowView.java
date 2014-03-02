package com.konrad.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
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
import java.io.File;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JButton;

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

           

  


                
                
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                panel.setLayout(null);
                frame.getContentPane().add(panel);
                PaintPane pane;
				try {
					pane = new PaintPane(ImageIO.read(new File("source\\aaa.png")));
				
                pane.setLayout(new BorderLayout());
                frame.getContentPane().add(pane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                
                SpringLayout springLayout = new SpringLayout();
                springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.WEST, panel, 964, SpringLayout.WEST, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.SOUTH, panel, 562, SpringLayout.NORTH, frame.getContentPane());
                frame.getContentPane().setLayout(springLayout);
                frame.getContentPane().add(panel);
                
                JButton btnNewButton = new JButton("New button");
                springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 168, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 247, SpringLayout.WEST, frame.getContentPane());
                frame.getContentPane().add(btnNewButton);
                
                JLabel lblNewLabel = new JLabel("New label");
                springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 267, SpringLayout.NORTH, frame.getContentPane());
                springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 93, SpringLayout.WEST, frame.getContentPane());
                frame.getContentPane().add(lblNewLabel);
                             
                
                frame.setSize(1000, 600);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
