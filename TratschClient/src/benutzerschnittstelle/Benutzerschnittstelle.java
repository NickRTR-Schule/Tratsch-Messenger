package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;

public class Benutzerschnittstelle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmpfaenger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			System.out.println("Error setting native LAF: " + e);
		}
		
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
		setBounds(100, 100, 454, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lstAngemeldeteBenutzer = new JList();
		lstAngemeldeteBenutzer.setBounds(6, 6, 173, 308);
		contentPane.add(lstAngemeldeteBenutzer);
		
		JTextArea txtTextnachrichten = new JTextArea();
		txtTextnachrichten.setBounds(191, 6, 257, 190);
		contentPane.add(txtTextnachrichten);
		
		JLabel lblAn = new JLabel("an:");
		lblAn.setBounds(191, 208, 19, 16);
		contentPane.add(lblAn);
		
		JTextArea txtEingabeTextnachricht = new JTextArea();
		txtEingabeTextnachricht.setBounds(191, 232, 257, 82);
		contentPane.add(txtEingabeTextnachricht);
		
		JButton btnAnmelden = new JButton("anmelden");
		btnAnmelden.setBounds(0, 326, 105, 29);
		contentPane.add(btnAnmelden);
		
		JButton btnAbmelden = new JButton("abmelden");
		btnAbmelden.setEnabled(false);
		btnAbmelden.setBounds(105, 326, 117, 29);
		contentPane.add(btnAbmelden);
		
		JButton btnSenden = new JButton("senden");
		btnSenden.setEnabled(false);
		btnSenden.setBounds(224, 326, 117, 29);
		contentPane.add(btnSenden);
		
		JButton btnLoeschen = new JButton("löschen");
		btnLoeschen.setEnabled(false);
		btnLoeschen.setBounds(337, 326, 117, 29);
		contentPane.add(btnLoeschen);
		
		txtEmpfaenger = new JTextField();
		txtEmpfaenger.setBackground(new Color(238, 239, 238));
		txtEmpfaenger.setEnabled(false);
		txtEmpfaenger.setEditable(false);
		txtEmpfaenger.setBounds(211, 203, 130, 26);
		contentPane.add(txtEmpfaenger);
		txtEmpfaenger.setColumns(10);
	}
}
