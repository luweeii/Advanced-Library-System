import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Admin_Librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Librarian frame = new Admin_Librarian();
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
	public Admin_Librarian() {
		setResizable(false);
		setTitle("WELCOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminLog = new JButton("Admin Login");
		adminLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin adminLog = new AdminLogin();
			adminLog.setVisible(true);
			dispose();
			}
		});
		adminLog.setBounds(157, 85, 122, 40);
		contentPane.add(adminLog);
		
		JButton librarianLog = new JButton("Librarian Login");
		librarianLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianLogin libLog = new LibrarianLogin();
			libLog.setVisible(true);
			dispose();
			}
		});
		librarianLog.setBounds(157, 160, 120, 40);
		contentPane.add(librarianLog);
		
		JLabel libraryTitle = new JLabel("Library Management System");
		libraryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		libraryTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		libraryTitle.setBounds(104, 26, 223, 38);
		contentPane.add(libraryTitle);
	}
}
