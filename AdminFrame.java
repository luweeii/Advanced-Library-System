import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeAdmin = new JLabel("Welcome to NU Library System");
		welcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		welcomeAdmin.setBounds(116, 65, 201, 85);
		contentPane.add(welcomeAdmin);
		
		JButton backBtn = new JButton("Back to Login");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin al = new AdminLogin();
			
			al.setVisible(true);
			dispose();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backBtn.setBounds(143, 139, 147, 46);
		contentPane.add(backBtn);
	}

}
