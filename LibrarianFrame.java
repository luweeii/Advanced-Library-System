import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LibrarianFrame extends JFrame {

	private ArrayList <Book> books = new ArrayList<>();
	private JPanel contentPane;
	private JTextField bookRent;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianFrame frame = new LibrarianFrame();
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
	public LibrarianFrame() {
		setResizable(false);
		setTitle("Library Rental System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(493, 496);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel book1 = new JLabel("Book #1: System Analysis and Design, Gary B. Shelly (2 copies available)");
		book1.setHorizontalAlignment(SwingConstants.LEFT);
		book1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book1.setBounds(21, 105, 431, 22);
		contentPane.add(book1);
		
		JLabel book3 = new JLabel("<html>Book #3: Programming Concepts and Logic Formulation, Gary B. Shelly (4 copies available)</html>");
		book3.setHorizontalAlignment(SwingConstants.LEFT);
		book3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book3.setBounds(21, 205, 431, 45);
		contentPane.add(book3);
		
		JLabel book2 = new JLabel("Book #2: Android Application. Corinne Hoisington (3 copies available)");
		book2.setHorizontalAlignment(SwingConstants.LEFT);
		book2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book2.setBounds(21, 155, 431, 22);
		contentPane.add(book2);
		
		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianLogin ll = new LibrarianLogin();
			ll.setVisible(true);
			dispose();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backBtn.setBounds(277, 375, 118, 34);
		contentPane.add(backBtn);
		
		JLabel chooseLbl = new JLabel("Choose a book number to for you to rent:");
		chooseLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chooseLbl.setBounds(21, 286, 247, 28);
		contentPane.add(chooseLbl);
		
		JButton rentBtn = new JButton("RENT");
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			int rent = Integer.parseInt(bookRent.getText());
			
			Book book1 = new Book();
			book1._name = "System Analysis and Design";
			book1._author = "Gary B. Shelly";
			book1._copy = 2;
			
			Book book2 = new Book();
			book2._name = "Android Application";
			book2._author = "Corinne Hoisington";
			book2._copy = 3;
			
			Book book3 = new Book();
			book3._name = "Programming Concepts and Logic Formulation";
			book3._author = "Gary B. Shelly";
			book3._copy = 4;
			
			books.add(null);
			books.add(book1);
			books.add(book2);
			books.add(book3);
			
			if (rent < 0 || rent >= books.size()) {
				JOptionPane.showMessageDialog(contentPane, "INDEX DOES NOT EXIST, Try Again!", "WARNING", JOptionPane.WARNING_MESSAGE);
				return;
			}
			Book book = books.get(rent);
			if (book.get_copy() > 0) {
				JOptionPane.showMessageDialog(contentPane, "YOU RENTED: " + books.get(rent).get_name());
				book.set_copy(book.get_copy() - 1);
			} else {
				JOptionPane.showMessageDialog(contentPane, "NO MORE COPIES LEFT", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
				}
		});
		rentBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rentBtn.setBounds(277, 331, 118, 34);
		contentPane.add(rentBtn);
		
		bookRent = new JTextField();
		bookRent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bookRent.setBounds(277, 283, 118, 34);
		contentPane.add(bookRent);
		bookRent.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Welcome to NU Library<br>Where you can rent your favorite books!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(33, 28, 415, 55);
		contentPane.add(lblNewLabel);
	}

}
