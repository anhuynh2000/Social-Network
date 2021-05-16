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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
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

	private String userName;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel labelClock;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(userName);
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
	public Home(String userName) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(5, 5, 1543, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 199, 57);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/SocialNetwork/Image/Logo_title.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(269, 22, 815, 23);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textField);
		textField.setColumns(75);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1100, 23, 70, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Avatar");
		lblNewLabel_1.setBounds(1198, 13, 87, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(userName);
		lblNewLabel_2.setFont(new Font("October Twilight", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(new Color(242, 141, 156));
		lblNewLabel_2.setBounds(1330, 5, 110, 50);
		panel.add(lblNewLabel_2);
		
		String list[] = {"Đổi mật khẩu", "Đăng xuất"};

		JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(1430, 25, 90, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Đăng xuất") {
					System.exit(1);
				}
			}
		
		});
		panel.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		panel_3.setBounds(5, 72, 1543, 864);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel labelClock = new JLabel();
		labelClock.setHorizontalAlignment(SwingConstants.CENTER);
		labelClock.setFont(new Font("Tahoma", Font.PLAIN, 37));
//		labelClock.setText("00:00");
		labelClock.setBounds(0, 10, 200, 74);
		labelClock.setVisible(true);
		
		panel_3.add(labelClock);

		
		
		
		
 		JTextPane textPane = new JTextPane();
		textPane.setBounds(5, 90, 200, 326);
		panel_3.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(5, 450, 200, 348);
		panel_3.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(1322, 10, 200, 788);
		panel_3.add(textPane_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(242, 141, 156));
		panel_4.setBounds(215, 10, 1097, 117);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 10, 900, 97);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Avatar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 10, 90, 97);
		panel_4.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBounds(1036, 82, 39, 35);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(242, 141, 156));
		panel_5.setBounds(215, 140, 1097, 666);
		panel_3.add(panel_5);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(1);
	            }
	        });
		  try {
	            while (true) {
	                Calendar calendar = Calendar.getInstance();
	                String hour = (calendar.getTime().getHours() > 9) ? 
	                        "" + calendar.getTime().getHours() + ""
	                        : "0" + calendar.getTime().getHours();
	                String minute = (calendar.getTime().getMinutes() > 9) ? 
	                        "" + calendar.getTime().getMinutes() + ""
	                        : "0" + calendar.getTime().getMinutes();
	                String second = (calendar.getTime().getSeconds() > 9) ? 
	                        "" + calendar.getTime().getSeconds() + ""
	                        : "0" + calendar.getTime().getSeconds();
	                labelClock.setText(hour + ":" + minute + ":" + second);
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException event) {
	            event.printStackTrace();
	        }
		 }
	
	class windowListener implements WindowListener{

		@SuppressWarnings("deprecation")
		@Override
		public void windowOpened(WindowEvent e) {
	       
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(1);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
