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
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private static String DB_URL = "jdbc:mysql://localhost:3306/social_network";
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
		//setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel username = new JLabel("Username");
		username.setBounds(572, 289, 87, 36);
		username.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		usernameField = new JTextField();
		usernameField.setBounds(665, 289, 236, 36);
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setBounds(572, 331, 89, 36);
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(665, 331, 236, 36);
		
		JCheckBox showPassword = new JCheckBox("Show password");
		showPassword.setBounds(700, 378, 159, 33);
		showPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
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
		
		
		JButton Login = new JButton("Login");
		Login.setBounds(676, 417, 83, 33);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean flag = false;
				try {
					Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					/*String updateQuery = "SELECT username, password FROM user WHERE username=? AND password=?";
					PreparedStatement ps = cnn.prepareStatement(updateQuery);
					
					ps.setString(1, username);
					ps.setString(2, password);
					
					ResultSet res = ps.executeQuery();
					if (res.next()) {
						Home home = new Home();
						home.setVisible(true);
						dispose();
					}*/
					String updateQuery = "SELECT userId,username, password FROM user";
					PreparedStatement ps = cnn.prepareStatement(updateQuery);
					ResultSet results = ps.executeQuery(updateQuery);
					
					while (results.next()) {
				        String userName = results.getString("username");
				        String passWord =  results.getString("password");

			           if ((username.equals(userName)) && (password.equals(passWord))) {
			        	   	flag = true;
			        	   	JOptionPane.showMessageDialog(null, "Username and Password exist");
		        	   		Home home = new Home(results.getString("userId"));
			        	   	home.setVisible(true);
			        	   	dispose();
				        } 
				        
				        if(!flag){
				        	JOptionPane.showMessageDialog(null, "Please Check Username and Password");
				        }
					}
					results.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton Register = new JButton("Register");
		Register.setBounds(786, 417, 105, 33);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registration = new Registration();
				registration.setVisible(true);
				dispose();
			}
		});
		Register.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(username);
		contentPane.add(usernameField);
		contentPane.add(password);
		contentPane.add(passwordField);
		contentPane.add(Login);
		contentPane.add(Register);
		contentPane.add(showPassword);
	}
}
