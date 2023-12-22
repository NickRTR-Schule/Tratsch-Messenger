package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import steuerung.Steuerung;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Benutzerschnittstelle extends JFrame
{

	private JPanel contentPane;
	private JList IstAngemeldetBenutzer;
	private JTextArea txtTextnachrichten;
	private JLabel lblAn;
	private JTextArea txtEingabeTextnachricht;
	private JButton btnAnmelden;
	private JButton btnAbmelden;
	private JButton btnSenden;
	private JButton btnLoeschen;
	private JTextField txtEmpfaenger;

	
	private Steuerung dieSteuerung;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Benutzerschnittstelle frame = new Benutzerschnittstelle();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benutzerschnittstelle()
	{
		setTitle("Tratsch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        try {
            dieSteuerung = new Steuerung(this);
        } catch (IOException e) {
            // TODO-js: Add Exception Code
        }

        IstAngemeldetBenutzer = new JList();
		IstAngemeldetBenutzer.setBounds(6, 6, 150, 299);
		contentPane.add(IstAngemeldetBenutzer);
		
		txtTextnachrichten = new JTextArea();
		txtTextnachrichten.setBounds(168, 6, 348, 174);
		contentPane.add(txtTextnachrichten);
		
		lblAn = new JLabel("an:");
		lblAn.setBounds(168, 190, 61, 16);
		contentPane.add(lblAn);
		
		txtEingabeTextnachricht = new JTextArea();
		txtEingabeTextnachricht.setBounds(168, 215, 348, 90);
		contentPane.add(txtEingabeTextnachricht);
		
		btnAnmelden = new JButton("anmelden");
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geklicktAnmelden();
			}
		});
		btnAnmelden.setBounds(6, 317, 117, 29);
		contentPane.add(btnAnmelden);
		
		btnAbmelden = new JButton("abmelden");
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				geklicktAbmelden();
			}
		});
		btnAbmelden.setBounds(132, 317, 117, 29);
		contentPane.add(btnAbmelden);
		
		btnSenden = new JButton("senden");
		btnSenden.setBounds(261, 317, 117, 29);
		contentPane.add(btnSenden);
		
		btnLoeschen = new JButton("löschen");
		btnLoeschen.setBounds(399, 317, 117, 29);
		contentPane.add(btnLoeschen);
		
		txtEmpfaenger = new JTextField();
		txtEmpfaenger.setBounds(196, 185, 320, 26);
		contentPane.add(txtEmpfaenger);
		txtEmpfaenger.setColumns(10);
	}
	
	private void geklicktAnmelden() 
	{
		LoginFenster dasLoginFenster = new LoginFenster();
		dasLoginFenster.setVisible(true);
	}
	
	private void geklicktAbmelden()
	{
		dieSteuerung.geklicktAbmelden();
	}
}
