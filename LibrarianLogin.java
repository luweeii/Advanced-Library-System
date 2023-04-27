import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianLogin extends JFrame {
	private String [][] admin = {{"Librarian 01", "LibOne"},
			{"Librarian 02", "LibTwo"},
			{"Librarian 03", "LibThree"}};
	private JPanel contentPane;
	private JTextField luInput;
	private JPasswordField lpInput;
	private JLabel lblwelcomeToLibrarian;
	private JButton backBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin frame = new LibrarianLogin();
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
	public LibrarianLogin() {
		setResizable(false);
		setTitle("Librarian Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameLabel.setBounds(109, 81, 79, 26);
		contentPane.add(usernameLabel);
		
		luInput = new JTextField();
		luInput.setColumns(10);
		luInput.setBounds(198, 79, 130, 26);
		contentPane.add(luInput);
		
		JLabel passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordLabel.setBounds(109, 128, 79, 26);
		contentPane.add(passwordLabel);
		
		lpInput = new JPasswordField();
		lpInput.setBounds(198, 126, 130, 26);
		contentPane.add(lpInput);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lUsername = luInput.getText();
				String lPassword = new String (lpInput.getPassword());
				boolean loggedIn = false;
				boolean correctUsername = false;
				boolean correctPassword = false;
				LibrarianFrame lf = new LibrarianFrame();
				
				for (int i = 0; i < admin.length; i++) {
			        if (admin[i][0].equals(lUsername) && admin[i][1].equals(lPassword)) {
			            loggedIn = true;
			            lf.setVisible(true);
			            dispose();
			            break;
			        } else if (admin[i][0].equals(lUsername) && !admin[i][1].equals(lPassword)) {
			            JOptionPane.showMessageDialog(contentPane, "INCORRECT PASSWORD", "Error", JOptionPane.ERROR_MESSAGE);
			            correctUsername = true; // Set to false
			            break;
			        } else if (!admin[i][0].equals(lUsername) && admin[i][1].equals(lPassword)) {
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
		loginBtn.setBounds(237, 176, 91, 26);
		contentPane.add(loginBtn);
		
		lblwelcomeToLibrarian = new JLabel("<html>Welcome to Librarian Login. Please input\r\n\tyour username and password</html>\r\n");
		lblwelcomeToLibrarian.setToolTipText("");
		lblwelcomeToLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcomeToLibrarian.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblwelcomeToLibrarian.setBounds(27, 23, 399, 36);
		contentPane.add(lblwelcomeToLibrarian);
		
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
