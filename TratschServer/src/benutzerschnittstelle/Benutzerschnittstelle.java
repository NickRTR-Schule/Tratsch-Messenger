package benutzerschnittstelle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Benutzerschnittstelle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benutzerschnittstelle frame = new Benutzerschnittstelle();
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
	public Benutzerschnittstelle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStarten = new JButton("start Server");
		btnStarten.setBounds(6, 6, 185, 29);
		contentPane.add(btnStarten);
		
		JButton btnStoppen = new JButton("stop Server");
		btnStoppen.setBounds(6, 38, 185, 29);
		contentPane.add(btnStoppen);
		
		JLabel lblAngemeldeteBenutzer = new JLabel("angemeldete Benutzer");
		lblAngemeldeteBenutzer.setBounds(15, 83, 167, 16);
		contentPane.add(lblAngemeldeteBenutzer);
		
		JTextArea txtAngemeldeteBenutzer = new JTextArea();
		txtAngemeldeteBenutzer.setBounds(13, 113, 172, 92);
		contentPane.add(txtAngemeldeteBenutzer);
		
		JTextArea txtMeldungen = new JTextArea();
		txtMeldungen.setBounds(203, 11, 558, 194);
		contentPane.add(txtMeldungen);
	}

}
