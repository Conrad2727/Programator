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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SumaryView extends JFrame {
	private JPanel contentPane2;
	SpringLayout sl_contentPane2 = new SpringLayout();
	private SumaryView frame2;
	JLabel lblNewLabel_1;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String answerid = "";
	private static String workplace = "";
	private static String workrole = "";
	private static String worksat = "";
	private static String changework = "";
	private static String wherewanna = "";
	private static String payment = "";
	private static String answerid2 = "";
	private static String workplace2 = "";
	private static String workrole2 = "";
	private static String worksat2 = "";
	private static String changework2 = "";
	private static String wherewanna2 = "";
	private static String payment2 = "";
	private static String answerid3 = "";
	private static String workplace3 = "";
	private static String workrole3 = "";
	private static String worksat3 = "";
	private static String changework3 = "";
	private static String wherewanna3 = "";
	private static String payment3 = "";
	private static String answerid4 = "";
	private static String workplace4 = "";
	private static String workrole4 = "";
	private static String worksat4 = "";
	private static String changework4 = "";
	private static String wherewanna4 = "";
	private static String payment4 = "";
	private static String answerid5 = "";
	private static String workplace5 = "";
	private static String workrole5 = "";
	private static String worksat5 = "";
	private static String changework5 = "";
	private static String wherewanna5 = "";
	private static String payment5 = "";

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
		contentPane2.setBackground(new Color(contentPane2.getBackground()
				.getRGB()));
		contentPane2.setSize(new Dimension(1000, 600));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(sl_contentPane2);

		JLabel lblNewLabel = new JLabel("Zestawienie odpowiedzi");
		lblNewLabel.setFont(new Font("Arabic Typesetting", Font.PLAIN, 40));
		sl_contentPane2.putConstraint(SpringLayout.NORTH, lblNewLabel, 29,
				SpringLayout.NORTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.WEST, lblNewLabel, 381,
				SpringLayout.WEST, contentPane2);
		contentPane2.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");

		sl_contentPane2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 50,
				SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 83,
				SpringLayout.WEST, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -413,
				SpringLayout.SOUTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.EAST, lblNewLabel_1, -56,
				SpringLayout.EAST, contentPane2);
		contentPane2.add(lblNewLabel_1);

		JButton button = new JButton("Poka¿");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// DerbySelect putSelection= new DerbySelect();
				// putSelection.selectMethod();
				selectMethod();
				lblNewLabel_1.setText(answerid + " " + workplace + " "
						+ workrole + " " + worksat + " " + changework + " "
						+ wherewanna + " " + payment);
				label.setText(answerid2 + " " + workplace2 + " " + workrole2
						+ " " + worksat2 + " " + changework2 + " "
						+ wherewanna2 + " " + payment2);
				label_1.setText(answerid3 + " " + workplace3 + " " + workrole3
						+ " " + worksat3 + " " + changework3 + " "
						+ wherewanna3 + " " + payment3);
				label_2.setText(answerid4 + " " + workplace4 + " " + workrole4
						+ " " + worksat4 + " " + changework4 + " "
						+ wherewanna4 + " " + payment4);
				label_3.setText(answerid5 + " " + workplace5 + " " + workrole5
						+ " " + worksat5 + " " + changework5 + " "
						+ wherewanna5 + " " + payment5);

			}

		});
		contentPane2.add(button);

		label = new JLabel("");
		sl_contentPane2.putConstraint(SpringLayout.NORTH, label, 62,
				SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.WEST, label, 0,
				SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, label, 85,
				SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.EAST, label, 845,
				SpringLayout.WEST, lblNewLabel_1);
		contentPane2.add(label);

		label_1 = new JLabel("");
		sl_contentPane2.putConstraint(SpringLayout.NORTH, label_1, 68,
				SpringLayout.SOUTH, label);
		sl_contentPane2.putConstraint(SpringLayout.WEST, label_1, 0,
				SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.EAST, label_1, 845,
				SpringLayout.WEST, lblNewLabel_1);
		contentPane2.add(label_1);

		label_2 = new JLabel("");
		sl_contentPane2.putConstraint(SpringLayout.NORTH, label_2, 415,
				SpringLayout.NORTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, label_1, -90,
				SpringLayout.NORTH, label_2);
		sl_contentPane2.putConstraint(SpringLayout.WEST, label_2, 0,
				SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.EAST, label_2, 829,
				SpringLayout.WEST, lblNewLabel_1);
		contentPane2.add(label_2);

		label_3 = new JLabel("");
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, label_2, -91,
				SpringLayout.NORTH, label_3);
		sl_contentPane2.putConstraint(SpringLayout.NORTH, label_3, 529,
				SpringLayout.NORTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.WEST, label_3, 0,
				SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane2.putConstraint(SpringLayout.SOUTH, label_3, -10,
				SpringLayout.SOUTH, contentPane2);
		sl_contentPane2.putConstraint(SpringLayout.EAST, label_3, 466,
				SpringLayout.WEST, lblNewLabel_1);
		contentPane2.add(label_3);

		JLabel background = new JLabel(new ImageIcon("source\\aaa.png"));
		contentPane2.add(background);

	}

	public void selectMethod() {
		try {

			connect = DriverManager
					.getConnection("jdbc:derby:Database\\MyDB;create=true");
			PreparedStatement statement = connect
					.prepareStatement("SELECT * from ANKIETA");

			resultSet = statement.executeQuery();
			int i = 0;
			while (resultSet.next()) {
				if (i == 0) {
					answerid = resultSet.getString("ANSWER_ID");
					workplace = resultSet.getString("WORKPLACE_NAME");
					workrole = resultSet.getString("WORK_ROLE");
					worksat = resultSet.getString("WORK_SAT");
					changework = resultSet.getString("ChANGE_WORK");
					wherewanna = resultSet.getString("WHERE_WANNA");
					payment = resultSet.getString("PAYMENT");
				} else if (i == 1) {
					answerid2 = resultSet.getString("ANSWER_ID");
					workplace2 = resultSet.getString("WORKPLACE_NAME");
					workrole2 = resultSet.getString("WORK_ROLE");
					worksat2 = resultSet.getString("WORK_SAT");
					changework2 = resultSet.getString("ChANGE_WORK");
					wherewanna2 = resultSet.getString("WHERE_WANNA");
					payment2 = resultSet.getString("PAYMENT");
				} else if (i == 2) {
					answerid3 = resultSet.getString("ANSWER_ID");
					workplace3 = resultSet.getString("WORKPLACE_NAME");
					workrole3 = resultSet.getString("WORK_ROLE");
					worksat3 = resultSet.getString("WORK_SAT");
					changework3 = resultSet.getString("ChANGE_WORK");
					wherewanna3 = resultSet.getString("WHERE_WANNA");
					payment3 = resultSet.getString("PAYMENT");
				} else if (i == 3) {
					answerid4 = resultSet.getString("ANSWER_ID");
					workplace4 = resultSet.getString("WORKPLACE_NAME");
					workrole4 = resultSet.getString("WORK_ROLE");
					worksat4 = resultSet.getString("WORK_SAT");
					changework4 = resultSet.getString("ChANGE_WORK");
					wherewanna4 = resultSet.getString("WHERE_WANNA");
					payment4 = resultSet.getString("PAYMENT");
				} else {
					answerid5 = resultSet.getString("ANSWER_ID");
					workplace5 = resultSet.getString("WORKPLACE_NAME");
					workrole5 = resultSet.getString("WORK_ROLE");
					worksat5 = resultSet.getString("WORK_SAT");
					changework5 = resultSet.getString("ChANGE_WORK");
					wherewanna5 = resultSet.getString("WHERE_WANNA");
					payment5 = resultSet.getString("PAYMENT");
				}

				i++;
			}

		} catch (Exception e) {

		} finally {

			close();
		}
	}

	public static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}