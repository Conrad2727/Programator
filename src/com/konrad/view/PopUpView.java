package com.konrad.view;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.konrad.db.*;

public class PopUpView extends JFrame {
	private JPanel contentPane;
	SpringLayout sl_contentPane = new SpringLayout();
	private PopUpView frame;
	DerbySelect chooseData = new DerbySelect();
	
	/**
	 * Launch the pop up vindow
	 */
	public static void popUpViewMethod() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpView frame = new PopUpView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PopUpView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 350, 200);
		contentPane = new JPanel();
        contentPane.setBackground(new Color(contentPane.getBackground().getRGB()));

		contentPane.setSize(new Dimension(1000, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Czy chcesz zobaczy\u0107 pozosta\u0142e wyniki?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 52, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tak");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chooseData.selectMethod();
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 73, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -39, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnNie = new JButton("Nie");
		btnNie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNie, 74, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNie, 0, SpringLayout.SOUTH, btnNewButton);
		contentPane.add(btnNie);
			

	}
}
