package SocialNetwork;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private static String DB_URL = "jdbc:mysql://10.124.2.137:3306/social_network";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "abcd1234";
	
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    
		setBounds(100, 100, 890, 575);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel logo_panel = new JPanel();
		
		logo_panel.setBackground(UIManager.getColor("TextField.background"));
		logo_panel.setBounds(0, 0, 450, 540);
		contentPane.add(logo_panel);
		logo_panel.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Login_Interface.class.getResource("/SocialNetwork/Image/Logo_buttefly.jpg")));
		Logo.setBounds(0, 0, 450, 450);
		logo_panel.add(Logo);
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(new Color(251, 238, 230));
		login_panel.setBounds(450, 0, 430, 540);
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel Login_text = new JLabel("Login");
		Login_text.setFont(new Font("October Twilight", Font.PLAIN, 40));
		Login_text.setForeground(new Color(242, 141, 156));
		Login_text.setBounds(162, 89, 128, 74);
		login_panel.add(Login_text);
		
		JLabel Logo_name = new JLabel("");
		Logo_name.setBounds(126, 487, 194, 43);
		login_panel.add(Logo_name);
		Logo_name.setIcon(new ImageIcon(Login_Interface.class.getResource("/SocialNetwork/Image/Logo.png")));
		
		JLabel username = new JLabel("Username");
		username.setForeground(new Color(243, 171, 182));
		username.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		username.setBounds(25, 203, 118, 36);
		login_panel.add(username);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setSelectedTextColor(new Color(255, 0, 0));
		usernameField.setSelectionColor(new Color(251, 238, 230));
		usernameField.setBounds(131, 203, 236, 36);
		login_panel.add(usernameField);
		
		JLabel password = new JLabel("Password");
		password.setForeground(new Color(243, 171, 182));
		password.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		password.setBounds(25, 245, 118, 36);
		login_panel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setSelectedTextColor(new Color(255, 0, 0));
		passwordField.setSelectionColor(new Color(251, 238, 230));
		passwordField.setBounds(131, 245, 236, 36);
		login_panel.add(passwordField);
		
		JCheckBox showPassword = new JCheckBox("");
		showPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		showPassword.setBackground(new Color(251, 238, 230));
		showPassword.setHorizontalAlignment(SwingConstants.CENTER);
		showPassword.setBounds(373, 255, 27, 21);
		showPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showPassword) {
					if (showPassword.isSelected()) {
						passwordField.setEchoChar((char) 0);
			        } else {
			        	passwordField.setEchoChar('*');
			        }
				 }
			}
		});
		login_panel.add(showPassword);
		
		
		JButton Login = new JButton("Login");
		Login.setBackground(new Color(159, 129, 137));
		Login.setForeground(new Color(255, 202, 212));
		Login.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Login.setBounds(131, 326, 83, 33);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				try {
					Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					String updateQuery = "SELECT username, password FROM user WHERE username=? AND password=?";
					PreparedStatement ps = cnn.prepareStatement(updateQuery);
					
					ps.setString(1, username);
					ps.setString(2, password);
					
					ResultSet res = ps.executeQuery();
					if (res.next()) {
						Home home = new Home();
						home.setVisible(true);
						dispose();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		login_panel.add(Login);
				JButton Register = new JButton("Register");
		Register.setBackground(new Color(255, 202, 212));
		Register.setForeground(new Color(159, 129, 137));
		Register.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Register.setBounds(249, 326, 118, 33);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registration = new Registration();
				registration.setVisible(true);
				dispose();
			}
		});
		login_panel.add(Register);
	
	}
}