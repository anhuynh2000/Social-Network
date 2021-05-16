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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener {

	private static String DB_URL = "jdbc:mysql://localhost:3306/social_network";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "abcd1234";
	private String userId;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField postField;
	private JLabel labelClock;
	private JLabel usernamePost;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(userId);
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
	public Home(String userId) {
		String username = null;
		Connection cnn;
		try {
			cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			String updateQuery = "SELECT username FROM user where userId="+userId;
			PreparedStatement ps = cnn.prepareStatement(updateQuery);
			ResultSet results = ps.executeQuery(updateQuery);
			while (results.next()) {
				username = results.getString("username");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		btnNewButton.setForeground(new Color(255, 245, 238));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("October Twilight", Font.PLAIN, 10));
		headerPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Avatar");
		lblNewLabel_1.setBounds(1198, 13, 87, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblNewLabel_1);
		
		JLabel usernameDisplay = new JLabel(username);
		usernameDisplay.setFont(new Font("October Twilight", Font.PLAIN, 25));
		usernameDisplay.setForeground(new Color(242, 141, 156));
		usernameDisplay.setBounds(1310, 12, 110, 50);
		headerPane.add(usernameDisplay);
		
		JPanel mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 228, 225));
		mainPane.setBounds(5, 72, 1543, 864);
		contentPane.add(mainPane);
		mainPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(215, 137, 1097, 661);
		mainPane.add(scrollPane);
		
		String list[] = {"Làm mới trang", "Đổi mật khẩu", "Đăng xuất"};

		JPanel newsfeedPanel = new JPanel();
		scrollPane.setViewportView(newsfeedPanel);
		newsfeedPanel.setBackground(new Color(242, 141, 156));
		newsfeedPanel.setLayout(new BoxLayout(newsfeedPanel, BoxLayout.Y_AXIS));
		
		JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(1430, 25, 90, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Đăng xuất") {
					System.exit(1);
				}
				if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Làm mới trang") {
					newsfeedPanel.removeAll();
					try {
						Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
						String updateQuery = "select* from post inner join user on user.userId = post.userId";
						PreparedStatement ps = cnn.prepareStatement(updateQuery);
						ResultSet results = ps.executeQuery(updateQuery);
						while(results.next()) {
							JPanel post = new JPanel();
							post.setMaximumSize(new Dimension(2160,200));
							post.setBackground(new Color(255, 228, 225));
							post.setBorder(new LineBorder(new Color(178, 34, 34), 2));

							newsfeedPanel.add(post);
							
							JLabel AvatarImage = new JLabel("Avatar");
							AvatarImage.setFont(new Font("Tahoma", Font.PLAIN, 30));
							
							JLabel usernamePost;
							
							usernamePost = new JLabel(results.getString("username"));
							
							usernamePost.setFont(new Font("October Twilight", Font.PLAIN, 15));
							usernamePost.setForeground(new Color(242, 141, 156));		
							
							JLabel date = new JLabel(results.getString("time"));
							date.setFont(new Font("Tahoma", Font.PLAIN, 15));
							
							JLabel content = new JLabel(results.getString("content"));
							content.setBackground(new Color(255, 250, 250));
							content.setFont(new Font("Tahoma", Font.PLAIN, 15));
							content.setBorder(new LineBorder(new Color(178, 34, 34), 2));
							
							GroupLayout gl_post = new GroupLayout(post);
							gl_post.setHorizontalGroup(
								gl_post.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_post.createSequentialGroup()
										.addContainerGap()
										.addComponent(AvatarImage, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_post.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_post.createSequentialGroup()
												.addComponent(usernamePost, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(date, 0, 0, Short.MAX_VALUE))
											.addComponent(content, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
										.addContainerGap())
							);
							gl_post.setVerticalGroup(
								gl_post.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_post.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_post.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_post.createSequentialGroup()
												.addGroup(gl_post.createParallelGroup(Alignment.BASELINE)
													.addComponent(usernamePost)
													.addComponent(date, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(content, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
											.addComponent(AvatarImage, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(82, Short.MAX_VALUE))
							);
							post.setLayout(gl_post);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		
		});
		
		
		headerPane.add(comboBox);
		
		
		
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
		try {
			cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			String updateQuery = "SELECT username FROM user";
			PreparedStatement ps = cnn.prepareStatement(updateQuery);
			ResultSet results = ps.executeQuery(updateQuery);
			while (results.next()) {
				username = results.getString("username");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JPanel postPane = new JPanel();
		postPane.setBackground(new Color(242, 141, 156));
		postPane.setBounds(215, 10, 1097, 117);
		mainPane.add(postPane);
		postPane.setLayout(null);
		
		postField = new JTextField();
		postField.setBounds(110, 10, 886, 97);
		postPane.add(postField);
		postField.setColumns(10);
		
		JLabel avaterImage = new JLabel("Avatar");
		avaterImage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		avaterImage.setBounds(10, 10, 90, 97);
		postPane.add(avaterImage);
		
		JButton postButton = new JButton("Post");
		postButton.setForeground(new Color(255, 245, 238));
		postButton.setBackground(new Color(178, 34, 34));
		postButton.setFont(new Font("October Twilight", Font.PLAIN, 15));
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cnn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					String updateQuery = "Insert into post (time, content, userId) values (?,?,?)";
					
					PreparedStatement ps = cnn.prepareStatement(updateQuery);
					java.util.Date dt = new java.util.Date();

					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					String currentTime = sdf.format(dt);
					ps.setString(1, currentTime);
					ps.setString(2, postField.getText());
					ps.setString(3, userId);
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		postButton.setBounds(1006, 35, 81, 47);
		postPane.add(postButton);
		
		JPanel friendPane = new JPanel();
		friendPane.setBounds(1322, 10, 200, 775);
		mainPane.add(friendPane);
		
		
		//from here
		//to here
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
