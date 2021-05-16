package SocialNetwork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Registration_Interface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField emailField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	private JButton Login_btn, Register;
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/social_network";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "abcd1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_Interface frame = new Registration_Interface();
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
	public Registration_Interface() {
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
		Logo.setIcon(new ImageIcon(Registration_Interface.class.getResource("/SocialNetwork/Image/Logo_butterfly.jpg")));
		Logo.setBounds(0, 0, 450, 450);
		logo_panel.add(Logo);
		
		JPanel register_panel = new JPanel();
		register_panel.setBackground(new Color(251, 238, 230));
		register_panel.setBounds(450, 0, 430, 540);
		contentPane.add(register_panel);
		register_panel.setLayout(null);
		
		JLabel Register_text = new JLabel("Register");
		Register_text.setFont(new Font("October Twilight", Font.PLAIN, 40));
		Register_text.setForeground(new Color(242, 141, 156));
		Register_text.setBounds(145, 25, 189, 74);
		register_panel.add(Register_text);
		
		JLabel Logo_name = new JLabel("");
		Logo_name.setBounds(125, 487, 194, 43);
		register_panel.add(Logo_name);
		Logo_name.setIcon(new ImageIcon(Registration_Interface.class.getResource("/SocialNetwork/Image/Logo.png")));
		
		JLabel firstName = new JLabel("First name");
		firstName.setForeground(new Color(243, 171, 182));
		firstName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		firstName.setBounds(25, 124, 118, 36);
		register_panel.add(firstName);
		
		fnameField = new JTextField();
		fnameField.setColumns(10);
		fnameField.setSelectedTextColor(new Color(255, 0, 0));
		fnameField.setSelectionColor(new Color(251, 238, 230));
		fnameField.setBounds(145, 124, 236, 36);
		register_panel.add(fnameField);
		
		JLabel lastName = new JLabel("Last name");
		lastName.setForeground(new Color(243, 171, 182));
		lastName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lastName.setBounds(25, 170, 118, 36);
		register_panel.add(lastName);
		
		lnameField = new JTextField();
		lnameField.setSelectedTextColor(new Color(255, 0, 0));
		lnameField.setSelectionColor(new Color(251, 238, 230));
		lnameField.setBounds(145, 171, 236, 36);
		register_panel.add(lnameField);
		
		
		Login_btn = new JButton("Back to login");
		Login_btn.setBackground(new Color(159, 129, 137));
		Login_btn.setForeground(new Color(255, 202, 212));
		Login_btn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Login_btn.setBounds(155, 370, 160, 25);
		Login_btn.addActionListener(this);
			
		register_panel.add(Login_btn);
		
		Register = new JButton("Register");
		Register.setBackground(new Color(255, 202, 212));
		Register.setForeground(new Color(159, 129, 137));
		Register.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Register.setBounds(155, 410, 160, 33);
		Register.addActionListener(this);
		register_panel.add(Register);
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(243, 171, 182));
		email.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		email.setBounds(25, 217, 118, 36);
		register_panel.add(email);
		
		emailField = new JTextField();
		emailField.setSelectionColor(new Color(251, 238, 230));
		emailField.setSelectedTextColor(Color.RED);
		emailField.setColumns(10);
		emailField.setBounds(145, 217, 236, 36);
		register_panel.add(emailField);
		
		JLabel username = new JLabel("Username");
		username.setForeground(new Color(243, 171, 182));
		username.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		username.setBounds(25, 263, 118, 36);
		register_panel.add(username);
		
		usernameField = new JTextField();
		usernameField.setSelectionColor(new Color(251, 238, 230));
		usernameField.setSelectedTextColor(Color.RED);
		usernameField.setBounds(145, 264, 236, 36);
		register_panel.add(usernameField);
		
		JLabel password = new JLabel("Password");
		password.setForeground(new Color(243, 171, 182));
		password.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		password.setBounds(25, 309, 118, 36);
		register_panel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setSelectionColor(new Color(251, 238, 230));
		passwordField.setSelectedTextColor(Color.RED);
		passwordField.setBounds(145, 310, 236, 36);
		register_panel.add(passwordField);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Login_btn) {
			Login login = new Login();
			login.setVisible(true);
			dispose();
		}
		
		if (e.getSource() == Register) {
			String username = usernameField.getText();
			String password = String.valueOf(passwordField.getPassword());
			String firstName = fnameField.getText();
			String lastName = lnameField.getText();
			String email = emailField.getText();
			boolean flag_user = true;
			boolean flag_email = true;
			boolean flag = true;
			
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
	}
}
