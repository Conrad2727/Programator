package com.konrad.view;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import com.konrad.db.*;


public class SumaryView extends JFrame {
	private JPanel contentPane2;
	SpringLayout sl_contentPane2 = new SpringLayout();
	private SumaryView frame2;
	JLabel lblNewLabel_1;
	
	public String answerid;
	public String workplace;
	public String workrole;
	public String worksat;
	public String changework;
	public String wherewanna;
	public String payment;
	
	/**
	 * Launch the pop up vindow
	 */
	public static void summaryViewMethod() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SumaryView frame = new SumaryView();
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
	public SumaryView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1000, 600);
		contentPane2 = new JPanel();
        contentPane2.setBackground(new Color(contentPane2.getBackground().getRGB()));
		contentPane2.setSize(new Dimension(1000, 600));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(sl_contentPane2);

		JLabel lblNewLabel = new JLabel("Zestawienie odpowiedzi");
		lblNewLabel.setFont(new Font("Arabic Typesetting", Font.PLAIN, 40));
		sl_contentPane2.putConstraint(SpringLayout.NORTH, lblNewLabel, 29, SpringLayout.NORTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.WEST, lblNewLabel, 381, SpringLayout.WEST, contentPane2);
		contentPane2.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		sl_contentPane2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 50, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 83, SpringLayout.WEST, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -75, SpringLayout.SOUTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.EAST, lblNewLabel_1, -56, SpringLayout.EAST, contentPane2);
		contentPane2.add(lblNewLabel_1);
				
		DerbySelect putSelection= new DerbySelect();
		putSelection.selectMethod(answerid, answerid, answerid, answerid, answerid, answerid, answerid);
		lblNewLabel_1.setText("Prosze" + answerid + workplace + workrole + worksat + changework + wherewanna + payment);
		
		

		JLabel background =  new JLabel (new ImageIcon ("source\\aaa.png"));
		contentPane2.add(background);

	}
}