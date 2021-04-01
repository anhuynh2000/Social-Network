package SocialNetwork;

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
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private static String DB_URL = "jdbc:mysql://localhost:3306/social_network";
	private static String USER_NAME = "root";
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
		//setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
				
		JCheckBox showPassword = new JCheckBox("Show password");
		
		
		JButton Login = new JButton("Login");
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
					if (e.getSource() == showPassword) {
						if (showPassword.isSelected()) {
							passwordField.setEchoChar((char) 0);
				        } else {
				        	passwordField.setEchoChar('*');
				        }
					 }
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registration = new Registration();
				registration.setVisible(true);
				dispose();
			}
		});
		Register.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(567)
					.addComponent(username)
					.addGap(6)
					.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(567)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(721)
					.addComponent(showPassword, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(671)
					.addComponent(Login)
					.addGap(27)
					.addComponent(Register))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(284)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(showPassword)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Login)
						.addComponent(Register)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
