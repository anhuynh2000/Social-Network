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
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		JPanel headerPane = new JPanel();
		headerPane.setBackground(new Color(255, 228, 225));
		headerPane.setBounds(5, 5, 1543, 67);
		contentPane.add(headerPane);
		headerPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 199, 57);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/SocialNetwork/Image/Logo_title.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(269, 22, 815, 23);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		headerPane.add(textField);
		textField.setColumns(75);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1100, 23, 70, 25);
		headerPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Avatar");
		lblNewLabel_1.setBounds(1198, 13, 87, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(userName);
		lblNewLabel_2.setFont(new Font("October Twilight", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(new Color(242, 141, 156));
		lblNewLabel_2.setBounds(1330, 5, 110, 50);
		headerPane.add(lblNewLabel_2);
		
		String list[] = {"Đổi mật khẩu", "Đăng xuất"};

		JComboBox comboBox = new JComboBox(list);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đổi mật khẩu\t", "Đăng xuất"}));
		comboBox.setBounds(1430, 25, 90, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Đăng xuất") {
					System.exit(1);
				}
			}
		
		});
		headerPane.add(comboBox);
		
		JPanel mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 228, 225));
		mainPane.setBounds(5, 72, 1543, 864);
		contentPane.add(mainPane);
		mainPane.setLayout(null);
		
		JLabel labelClock = new JLabel();
		labelClock.setHorizontalAlignment(SwingConstants.CENTER);
		labelClock.setFont(new Font("Tahoma", Font.PLAIN, 37));
//		labelClock.setText("00:00");
		labelClock.setBounds(0, 10, 200, 74);
		labelClock.setVisible(true);
		
		mainPane.add(labelClock);

		
		
		
		
 		JTextPane textPane = new JTextPane();
		textPane.setBounds(5, 90, 200, 326);
		mainPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(5, 450, 200, 348);
		mainPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(1322, 10, 200, 788);
		mainPane.add(textPane_2);
		
		JPanel postPane = new JPanel();
		postPane.setBackground(new Color(242, 141, 156));
		postPane.setBounds(215, 10, 1097, 117);
		mainPane.add(postPane);
		postPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 10, 900, 97);
		postPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Avatar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 10, 90, 97);
		postPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(1036, 82, 39, 35);
		postPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(215, 137, 1097, 661);
		mainPane.add(scrollPane);
		
		JPanel newsfeedPanel = new JPanel();
		scrollPane.setViewportView(newsfeedPanel);
		newsfeedPanel.setBackground(new Color(242, 141, 156));
		newsfeedPanel.setLayout(new BoxLayout(newsfeedPanel, BoxLayout.Y_AXIS));
		
		JPanel post = new JPanel();
		post.setMaximumSize(new Dimension(2160,200));
		newsfeedPanel.add(post);
		
		JLabel AvatarImage = new JLabel("Avatar");
		AvatarImage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel username = new JLabel("username");
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel date = new JLabel("date");
		date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel content = new JLabel("content");
		content.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_post = new GroupLayout(post);
		gl_post.setHorizontalGroup(
			gl_post.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_post.createSequentialGroup()
					.addContainerGap()
					.addComponent(AvatarImage, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_post.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_post.createSequentialGroup()
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(date, 0, 0, Short.MAX_VALUE)
							.addGap(746))
						.addGroup(gl_post.createSequentialGroup()
							.addComponent(content, GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_post.setVerticalGroup(
			gl_post.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_post.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_post.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_post.createSequentialGroup()
							.addGroup(gl_post.createParallelGroup(Alignment.BASELINE)
								.addComponent(username)
								.addComponent(date))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(content, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
						.addComponent(AvatarImage, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		post.setLayout(gl_post);
		
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
