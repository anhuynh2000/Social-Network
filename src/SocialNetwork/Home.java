package SocialNetwork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Color;

@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener {

	private String userID;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(userID);
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
	@SuppressWarnings("deprecation")
	public Home(String userID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Windows\\Desktop\\Social-Network\\src\\SocialNetwork\\Image\\Logo_title.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textField);
		textField.setColumns(75);
		
		JButton btnNewButton = new JButton("Search");
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Avatar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username.........................................");
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel labelClock = new JLabel();
		labelClock.setHorizontalAlignment(SwingConstants.CENTER);
		labelClock.setFont(new Font("Tahoma", Font.PLAIN, 37));
		labelClock.setText("00:00");
		labelClock.setBounds(0, 10, 200, 74);
		
		panel_3.add(labelClock);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 94, 200, 326);
		panel_3.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(0, 450, 200, 200);
		panel_3.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(1292, 10, 200, 700);
		panel_3.add(textPane_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(210, 10, 1070, 117);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 10, 920, 97);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Avatar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 10, 90, 97);
		panel_4.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBounds(1031, 82, 39, 35);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 228, 225));
		panel_5.setBounds(210, 140, 1070, 570);
		panel_3.add(panel_5);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
