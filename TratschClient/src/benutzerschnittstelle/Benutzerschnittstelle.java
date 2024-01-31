package benutzerschnittstelle;

import steuerung.Steuerung;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
    private final ArrayList<String> ausgewaehlteEmpfaenger = new ArrayList<>();
    private Steuerung dieSteuerung;

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
        	JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
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
                oeffneLoginFenster();
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
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

    private void oeffneLoginFenster() {
        LoginFenster dasLoginFenster = new LoginFenster(this);
        dasLoginFenster.setVisible(true);
    }

    public void geklicktAnmelden(String pBenutzername, String pPasswort) {
        dieSteuerung.geklicktAnmelden(pBenutzername, pPasswort);
    }

    private void geklicktAnmelden() {
        LoginFenster dasLoginFenster = new LoginFenster(this);
        dasLoginFenster.setVisible(true);
    }

    private void geklicktAbmelden() {
        //dieSteuerung.geklicktAbmelden();
    }

    private void ausgewaehltEmpfaenger() {
        ausgewaehlteEmpfaenger.add(txtEmpfaenger.getText());
    }

    public void erfolgreichAbgemeldet() {
    	
    }

    public void erfolgreichAngemeldet(String pBenutzername) {

    }

    private void geklicktLoeschen() {
    	
    }

    private void geklicktSenden() {

    }

    private void loescheEingabeTextnachricht() {
    	txtEingabeTextnachricht.setText("");
    }

    public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer) {

    }

    private void zeigeFenstertitel(String pBenutzername) {
    	setTitle("Tratsch " + pBenutzername);
    }

    public void zeigeMeldung(String pMeldung) {
    	JOptionPane.showMessageDialog(this, pMeldung);
    }

    public void zeigeTextnachricht(String pAbsender, String pEmpfaenger, String pTextnachricht) {
    	txtTextnachrichten.append(pAbsender + " an " + pEmpfaenger + ":/r/n");
    	txtTextnachrichten.append(pTextnachricht + "/r/n");
    	txtTextnachrichten.append("---/r/n");
    	
    }
}
