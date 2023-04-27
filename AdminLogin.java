import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private String [][] admin = {{"Admin 01", "AdminOne"},
								{"Admin 02", "AdminTwo"},
								{"Admin 03", "AdminThree"}};
	private JPanel contentPane;
	private JTextField auInput;
	private JPasswordField apInput;
	private JLabel lblNewLabel;
	private JButton backBtn;
						  
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setResizable(false);
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBounds(93, 80, 79, 26);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordLabel.setBounds(93, 127, 79, 26);
		contentPane.add(passwordLabel);
		
		auInput = new JTextField();
		auInput.setBounds(182, 78, 130, 26);
		contentPane.add(auInput);
		auInput.setColumns(10);
		
		apInput = new JPasswordField();
		apInput.setBounds(182, 125, 130, 26);
		contentPane.add(apInput);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String aUsername = auInput.getText();
			String aPassword = new String (apInput.getPassword());
			boolean loggedIn = false;
			boolean correctUsername = false;
			boolean correctPassword = false;
			AdminFrame af = new AdminFrame();
			
			for (int i = 0; i < admin.length; i++) {
		        if (admin[i][0].equals(aUsername) && admin[i][1].equals(aPassword)) {
		            loggedIn = true;
		            af.setVisible(true);
		            dispose();
		            break;
		        } else if (admin[i][0].equals(aUsername) && !admin[i][1].equals(aPassword)) {
		            JOptionPane.showMessageDialog(contentPane, "INCORRECT PASSWORD", "Error", JOptionPane.ERROR_MESSAGE);
		            correctUsername = true; // Set to false
		            break;
		        } else if (!admin[i][0].equals(aUsername) && admin[i][1].equals(aPassword)) {
		            JOptionPane.showMessageDialog(contentPane, "INCORRECT USERNAME", "Error", JOptionPane.ERROR_MESSAGE);
		            correctPassword = true; // Set to false
		        }
		    }
		    if (!loggedIn && !correctUsername && !correctPassword) { // Check if both are false
		        JOptionPane.showMessageDialog(contentPane, "INCORRECT USERNAME AND PASSWORD", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtn.setBounds(237, 175, 91, 26);
		contentPane.add(loginBtn);
		
		lblNewLabel = new JLabel("<html>Welcome to Admin Login. Please input\r\n\tyour username and password</html>\r\n");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(27, 24, 399, 36);
		contentPane.add(lblNewLabel);
		
		backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin_Librarian main = new Admin_Librarian();
			main.setVisible(true);
			dispose();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backBtn.setBounds(120, 176, 91, 26);
		contentPane.add(backBtn);
	}
}
