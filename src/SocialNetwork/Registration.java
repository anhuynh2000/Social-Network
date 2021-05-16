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
import javax.swing.JOptionPane;
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel username = new JLabel("Username");
		username.setBounds(572, 301, 87, 36);
		username.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel password = new JLabel("Password");
		password.setBounds(572, 343, 89, 36);
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel firstName = new JLabel("Firstname");
		firstName.setBounds(572, 385, 89, 36);
		firstName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lastName = new JLabel("Lastname");
		lastName.setBounds(572, 427, 89, 36);
		lastName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel email = new JLabel("Email");
		email.setBounds(572, 469, 89, 36);
		email.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		usernameField = new JTextField();
		usernameField.setBounds(665, 301, 236, 36);
		usernameField.setColumns(10);
		
		firstnameField = new JTextField();
		firstnameField.setBounds(665, 385, 236, 36);
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(665, 427, 236, 36);
		lastnameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(665, 469, 236, 36);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(665, 343, 236, 36);
		
		JButton Register = new JButton("Register");
		Register.setBounds(707, 511, 105, 33);
		
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String firstName = firstnameField.getText();
				String lastName = lastnameField.getText();
				String email = emailField.getText();
				boolean flag_user = true;
				boolean flag_email = true;
				
				
				try {
					Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					String checkQuery = "SELECT username,email FROM user";
					PreparedStatement psCheck = cnn.prepareStatement(checkQuery);
					ResultSet results = psCheck.executeQuery(checkQuery);
					
					while (results.next()) {
						String userName = results.getString("username");
				        String eMail =  results.getString("email");

				       if (username.equals(userName)) {
				    	   flag_user = false;
				    	   break;
				       }
				       if (email.equals(eMail)) {
				    	   flag_email = false;
				    	   break;
				       }
					}
			       if(flag_user == true) {
			    	   if(flag_email == true) {
			    		   	String updateQuery = "INSERT INTO user (username,firstName,lastName,email,password) VALUES (?,?,?,?,?)";
							PreparedStatement ps = cnn.prepareStatement(updateQuery);
							ps.setString(1, username);
							ps.setString(2, firstName);
							ps.setString(3, lastName);
							ps.setString(4, email);
							ps.setString(5, password);
							
							ps.executeUpdate();
							
							JOptionPane.showMessageDialog(passwordField, "Register successfully.");
			    	   } else {
			    		   JOptionPane.showMessageDialog(passwordField, "Email is already used.");
			    	   }
			       } else {
			    	   JOptionPane.showMessageDialog(passwordField, "Username is already used.");
			       }
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Register.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton Login = new JButton("Return to Login Page");
		Login.setBounds(15, 15, 215, 33);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(username);
		contentPane.add(usernameField);
		contentPane.add(password);
		contentPane.add(passwordField);
		contentPane.add(firstName);
		contentPane.add(firstnameField);
		contentPane.add(lastName);
		contentPane.add(lastnameField);
		contentPane.add(email);
		contentPane.add(emailField);
		contentPane.add(Register);
		contentPane.add(Login);
	}

}
