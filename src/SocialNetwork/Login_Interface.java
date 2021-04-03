package SocialNetwork;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Login_Interface extends JFrame {

	static int width = 755, height = 575;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Interface frame = new Login_Interface();
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
	public Dimension getPreferredSize() {
        return new Dimension(350, 300);
    }
	
	public Login_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
		setBounds(100, 100, 891, 575);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel logo_panel = new JPanel();
		int w_panel = width/2, h_panel = height;
		
		logo_panel.setBackground(UIManager.getColor("TextField.background"));
		logo_panel.setBounds(0, 0, 449, 538);
		contentPane.add(logo_panel);
		logo_panel.setLayout(null);
		
		JLabel Logo_name = new JLabel("");
		Logo_name.setBounds(151, 338, 200, 200);
		Logo_name.setIcon(new ImageIcon(Login_Interface.class.getResource("/SocialNetwork/Image/Logo.png")));
		logo_panel.add(Logo_name);
		
		JLabel Logo_butterfly = new JLabel("");
		Logo_butterfly.setBounds(0, 10, 439, 456);
		logo_panel.add(Logo_butterfly);
		Logo_butterfly.setBackground(SystemColor.textHighlightText);
		Logo_butterfly.setIcon(new ImageIcon(Login_Interface.class.getResource("/SocialNetwork/Image/Logo_butterfly.jpg")));
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(new Color(255, 235, 205));
		login_panel.setBounds(448, 0, 429, 538);
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setForeground(new Color(205, 92, 92));
		username.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		username.setBounds(25, 203, 118, 36);
		login_panel.add(username);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(131, 203, 236, 36);
		login_panel.add(textField);
		
		JLabel password = new JLabel("Password");
		password.setForeground(new Color(205, 92, 92));
		password.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		password.setBounds(25, 245, 118, 36);
		login_panel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 245, 236, 36);
		login_panel.add(passwordField);
		
		JCheckBox showPassword = new JCheckBox("");
		showPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		showPassword.setBackground(new Color(255, 235, 205));
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
		Login.setBackground(new Color(255, 228, 225));
		Login.setForeground(new Color(205, 92, 92));
		Login.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Login.setBounds(131, 326, 83, 33);
		login_panel.add(Login);
		
		JButton Register = new JButton("Register");
		Register.setForeground(new Color(205, 92, 92));
		Register.setBackground(new Color(255, 228, 225));
		Register.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Register.setBounds(242, 326, 118, 33);
		login_panel.add(Register);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("October Twilight", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(205, 92, 92));
		lblNewLabel.setBounds(162, 89, 128, 74);
		login_panel.add(lblNewLabel);
	}
}
