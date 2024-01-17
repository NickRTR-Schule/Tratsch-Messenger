package benutzerschnittstelle;

import steuerung.Steuerung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import steuerung.Steuerung;

import java.awt.*;
import java.util.ArrayList;

import steuerung.Steuerung;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Benutzerschnittstelle extends JFrame {

    private final JPanel contentPane;
    private final JList IstAngemeldetBenutzer;
    private final JTextArea txtTextnachrichten;
    private final JLabel lblAn;
    private final JTextArea txtEingabeTextnachricht;
    private final JButton btnAnmelden;
    private final JButton btnAbmelden;
    private final JButton btnSenden;
    private final JButton btnLoeschen;
    private final JTextField txtEmpfaenger;

    private Steuerung dieSteuerung;

    /**
     * Create the frame.
     */
    public Benutzerschnittstelle() {
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
            // TODO-js: Add Exception Code: show exception message in window
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
                
            }
        });
        btnAnmelden.setBounds(6, 317, 117, 29);
        contentPane.add(btnAnmelden);

        btnAbmelden = new JButton("abmelden");
        btnAbmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geklicktAbmelden();
            }
        });
        btnAbmelden.setBounds(132, 317, 117, 29);
        contentPane.add(btnAbmelden);

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

	private void ausgewaehltEmpfaenger() {
		ausgewaehlteEmpfaenger.add(txtEmpfaenger.getText());
	}

	private void erfolgreichAbgemeldet() {

	}

	public void erfolgreichAngemeldet(String pBenutzername) {

	}

	private void geklicktAbmelden() {

	}

	private void geklicktAnmelden() {
	}

	private void geklicktLoeschen() {

	}

	private void geklicktSenden() {

	}

	private void loescheEingabeTextnachricht() {

	}

	public void zeigeAngemeldeteBenutzer(String pAngemeldeteBenutzer) {

	}

	private void zeigeFenstertitel(String pBenutzername) {

	}

	public void zeigeMeldung(String pMeldung) {

	}

	public void zeigeTextnachricht(String pAbsender, String pEmpfaenger, String pTextnachricht) {

	}
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
		
		EventQueue.invokeLater(() -> {
            try {
                Benutzerschnittstelle frame = new Benutzerschnittstelle();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
       
    }

    private void geklicktAnmelden() {
        LoginFenster dasLoginFenster = new LoginFenster(this);
        dasLoginFenster.setVisible(true);
    }
	
	
	private void geklicktAbmelden()
	{
		dieSteuerung.geklicktAbmelden();
	}
}
