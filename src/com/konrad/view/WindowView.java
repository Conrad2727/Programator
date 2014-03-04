package com.konrad.view;


import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.konrad.db.*;

public class WindowView extends JFrame {

	private JPanel contentPane;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JRadioButton rdbtnTak;
	private static JRadioButton rdbtnNie;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<?> list;
	private JComboBox<?> comboBox;

	String	listData[] =
		{
			"kiepsko",
			"mo¿e byæ",
			"ca³kiem nieŸle",
			"lubie",
			"super extra"
		};
	
	String	paymentData[] =
		{
			"< 1500",
			"1500 - 2500",
			"2500 - 3000",
			"3000 - 3500",
			"3500 - 4000"
		};

	String textdata2;
	String textdata3;
	String textdata4;
	String combodata1;
	String combodata2;
	SpringLayout sl_contentPane = new SpringLayout();
	DerbyInsertRows insertRows = new DerbyInsertRows();
	JdbcDerbyConnection drbConn = new JdbcDerbyConnection();
	
	
	/**
	 * Launch the application.
	 */
	public static void windowViewMethod() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowView frame = new WindowView();
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
	public WindowView() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1000, 600));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(sl_contentPane);
			
		JButton btnNewButton = new JButton("Zapisz");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textdata2 = textField.getText();
				textdata3 = textField_1.getText();
				textdata4 = textField_2.getText();	
				combodata1 = (String) list.getSelectedItem();
				combodata2 = (String) comboBox.getSelectedItem();
				insertRows.insertToDatabase();
//				drbConn.derbyConnected();
				lblNewLabel_2.setText("Pracujesz w firmie " + textdata3 +", na stanowisku " + textdata2+". " + "Twój stosunek do pracy to: " + combodata1 + " i chcia³byœ zarabiaæ: " + combodata2 + ".");
				if (rdbtnTak.isSelected())
					lblNewLabel_3.setText("W przysz³oœci chcesz pracowaæ w bran¿y: " + textdata4 +  " i chcesz zmieniæ pracê w przysz³oœci.");
				else
					lblNewLabel_3.setText("W przysz³oœci chcesz pracowaæ w bran¿y: " + textdata4 +  " i nie chcesz zmieniæ pracy w przysz³oœci.");
					
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 499, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -441, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Po naci\u015Bni\u0119ciu przycisku dane zostan\u0105 przekazane do bazy danych.");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -27, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -272, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gdzie pracujesz? (Podaj nazw\u0119 zak\u0142adu)");
		lblNewLabel_1.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 53, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 86, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNaJakimStanowisku = new JLabel("Na jakim stanowisku pracujesz?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNaJakimStanowisku, 61, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNaJakimStanowisku, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNaJakimStanowisku.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblNaJakimStanowisku);
		
		JLabel lblOceZadowolenieZ = new JLabel("Oce\u0144 zadowolenie z pracy od 1 do 5.");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOceZadowolenieZ, 0, SpringLayout.WEST, lblNewLabel_1);
		lblOceZadowolenieZ.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblOceZadowolenieZ);
		
		JLabel lblCzyPlanujeszZmieni = new JLabel("Czy planujesz zmieni\u0107 prac\u0119?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCzyPlanujeszZmieni, 0, SpringLayout.NORTH, lblNewLabel_1);
		lblCzyPlanujeszZmieni.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblCzyPlanujeszZmieni);
		
		JLabel lblWJakiejBrany = new JLabel("W jakiej bran\u017Cy chcesz pracowa\u0107?");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWJakiejBrany, 192, SpringLayout.EAST, lblNaJakimStanowisku);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCzyPlanujeszZmieni, 0, SpringLayout.WEST, lblWJakiejBrany);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblWJakiejBrany, 0, SpringLayout.SOUTH, lblNaJakimStanowisku);
		lblWJakiejBrany.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblWJakiejBrany);
		
		JLabel lblCzyTwojeZarobki = new JLabel("Ile chcia\u0142by\u015B zarabia\u0107?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCzyTwojeZarobki, 59, SpringLayout.SOUTH, lblWJakiejBrany);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCzyTwojeZarobki, 161, SpringLayout.EAST, lblOceZadowolenieZ);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOceZadowolenieZ, 0, SpringLayout.NORTH, lblCzyTwojeZarobki);
		lblCzyTwojeZarobki.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblCzyTwojeZarobki);
			
		list = new JComboBox(listData);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(list);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 88, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -19, SpringLayout.NORTH, lblOceZadowolenieZ);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 20, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, lblCzyPlanujeszZmieni);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, textField);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		rdbtnTak = new JRadioButton("Tak");
		rdbtnTak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnNie.setSelected(false);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTak, 284, SpringLayout.EAST, textField_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnTak, 0, SpringLayout.SOUTH, textField_1);
		rdbtnTak.setSelected(true);
		contentPane.add(rdbtnTak);
		
		
		rdbtnNie = new JRadioButton("Nie");
		rdbtnNie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnTak.setSelected(false);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnNie, 45, SpringLayout.EAST, rdbtnTak);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnNie, 0, SpringLayout.SOUTH, textField_1);
		contentPane.add(rdbtnNie);
			
		comboBox = new JComboBox(paymentData);
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 13, SpringLayout.SOUTH, lblCzyTwojeZarobki);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, lblCzyPlanujeszZmieni);
		contentPane.add(comboBox);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 91, SpringLayout.SOUTH, list);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 140, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
			
		lblNewLabel_3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 112, SpringLayout.SOUTH, list);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		lblNewLabel_3.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3);
		
		JLabel background =  new JLabel (new ImageIcon ("source\\aaa.png"));
		contentPane.add(background);
	}
}
