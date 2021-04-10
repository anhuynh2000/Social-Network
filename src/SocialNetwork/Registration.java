package SocialNetwork;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

@SuppressWarnings({ "serial", "unused" })
public class Registration extends JFrame {
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	
	private static String DB_URL = "jdbc:mysql://10.124.2.137:3306/social_network";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "abcd1234";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 533, 546);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel firstName = new JLabel("Firstname");
		firstName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lastName = new JLabel("Lastname");
		lastName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		firstnameField = new JTextField();
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton Register = new JButton("Register");
		
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String firstName = firstnameField.getText();
				String lastName = lastnameField.getText();
				String email = emailField.getText();
				
				try {
					Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					String updateQuery = "INSERT INTO user (username,firstName,lastName,email,password) VALUES (?,?,?,?,?)";
					PreparedStatement ps = cnn.prepareStatement(updateQuery);
					
					ps.setString(1, username);
					ps.setString(2, firstName);
					ps.setString(3, lastName);
					ps.setString(4, email);
					ps.setString(5, password);
					
					ps.executeUpdate();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Register.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton Login = new JButton("Return to Login Page");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(567)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(username)
									.addGap(6)
									.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(firstName)
									.addGap(4)
									.addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lastName, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lastnameField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(email, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(135)
									.addComponent(Register))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(Login)))
					.addContainerGap(616, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Login)
					.addGap(253)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(firstnameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastnameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(Register)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
