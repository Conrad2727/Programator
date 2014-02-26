package com.konrad.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class mainView	{
	private static JTextField textField;
	private static JPasswordField passwordField;

    public static void main(String[] args) {
        if (true) {
            try {
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JButton button1 = new JButton("Zaloguj si\u0119");
                button1.putClientProperty("JButton.buttonType", "segmented");
                button1.putClientProperty("JButton.segmentPosition", "first");

                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(new Color(panel.getBackground().getRGB()));
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SpringLayout sl_panel = new SpringLayout();
                sl_panel.putConstraint(SpringLayout.NORTH, button1, 157, SpringLayout.NORTH, panel);
                panel.setLayout(sl_panel);

                panel.add(button1);

                JFrame frame = new JFrame();
                frame.setAutoRequestFocus(false);
                frame.getContentPane().add(panel, BorderLayout.CENTER);
                
                textField = new JTextField();
                sl_panel.putConstraint(SpringLayout.EAST, button1, 0, SpringLayout.EAST, textField);
                sl_panel.putConstraint(SpringLayout.NORTH, textField, 68, SpringLayout.NORTH, panel);
                panel.add(textField);
                textField.setColumns(10);            
                
                passwordField = new JPasswordField();
                sl_panel.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
                sl_panel.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, button1);
                panel.add(passwordField);
                
                JLabel lblLogin = new JLabel("Login");
                sl_panel.putConstraint(SpringLayout.EAST, lblLogin, -316, SpringLayout.EAST, panel);
                sl_panel.putConstraint(SpringLayout.WEST, textField, 19, SpringLayout.EAST, lblLogin);
                sl_panel.putConstraint(SpringLayout.NORTH, lblLogin, 3, SpringLayout.NORTH, textField);
                panel.add(lblLogin);
                
                JLabel lblNewLabel = new JLabel("Has\u0142o");
                sl_panel.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblNewLabel);
                sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.SOUTH, lblLogin);
                sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblLogin);
                panel.add(lblNewLabel);
                
                JLabel lblNewLabel_1 = new JLabel("Loger 2014 1.0");
                lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
                sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel);
                sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel);
                panel.add(lblNewLabel_1);
                frame.setSize(531, 289);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
