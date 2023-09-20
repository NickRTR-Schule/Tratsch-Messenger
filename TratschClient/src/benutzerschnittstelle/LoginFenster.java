package benutzerschnittstelle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginFenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBenutzername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFenster frame = new LoginFenster();
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
	public LoginFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 139, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBenutzername = new JTextField();
		txtBenutzername.setBounds(6, 28, 130, 26);
		contentPane.add(txtBenutzername);
		txtBenutzername.setColumns(10);
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(10, 7, 104, 16);
		contentPane.add(lblBenutzername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(11, 66, 122, 16);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(6, 85, 130, 26);
		contentPane.add(txtPassword);
		
		JButton btnAnmelden = new JButton("anmelden");
		btnAnmelden.setBounds(2, 127, 134, 29);
		contentPane.add(btnAnmelden);
		
		JButton btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setBounds(3, 157, 133, 29);
		contentPane.add(btnAbbrechen);
	}

}
