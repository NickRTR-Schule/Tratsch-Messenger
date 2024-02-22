package benutzerschnittstelle;

import steuerung.Steuerung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Benutzerschnittstelle extends JFrame {

    private final JPanel contentPane;
    private final JTextArea txtTextnachrichten;
    private final JTextArea txtEingabeTextnachricht;
    private final JTextField txtEmpfaenger;
    private final ArrayList<String> ausgewaehlteEmpfaenger = new ArrayList<>();
    private final JButton logBtn;
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private Steuerung dieSteuerung;
    private LoginFenster dasLoginFenster;

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
            JOptionPane.showMessageDialog(this, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        JList<String> istAngemeldetBenutzer = getStringJList();
        contentPane.add(istAngemeldetBenutzer);

        txtTextnachrichten = new JTextArea();
        txtTextnachrichten.setBounds(168, 6, 348, 174);
        txtTextnachrichten.setEditable(false);
        contentPane.add(txtTextnachrichten);

        JLabel lblAn = new JLabel("an:");
        lblAn.setBounds(168, 190, 61, 16);
        contentPane.add(lblAn);

        txtEingabeTextnachricht = new JTextArea();
        txtEingabeTextnachricht.setBounds(168, 215, 348, 90);
        contentPane.add(txtEingabeTextnachricht);

        logBtn = new JButton();
        logBtn.setText("anmelden");
        logBtn.addActionListener(e -> logBtnAction());
        logBtn.setBounds(6, 317, 117, 29);
        contentPane.add(logBtn);

        JButton btnSenden = new JButton("senden");
        btnSenden.setBounds(261, 317, 117, 29);
        btnSenden.addActionListener(e -> geklicktSenden());
        contentPane.add(btnSenden);

        JButton btnLoeschen = new JButton("löschen");
        btnLoeschen.addActionListener(e -> geklicktLoeschen());
        btnLoeschen.setBounds(399, 317, 117, 29);
        contentPane.add(btnLoeschen);
        btnLoeschen.addActionListener(e -> geklicktLoeschen());

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

    private JList<String> getStringJList() {
        JList<String> istAngemeldetBenutzer = new JList<>(model);
        istAngemeldetBenutzer.setBounds(6, 6, 150, 299);
        istAngemeldetBenutzer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ausgewaehltEmpfaenger();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        return istAngemeldetBenutzer;
    }

    private void oeffneLoginFenster() {
        dasLoginFenster = new LoginFenster(this);
        dasLoginFenster.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dasLoginFenster.setVisible(true);

    }

    public void geklicktAnmelden(String pBenutzername, String pPasswort) { //muss public sein, da es im Login-Fenster aufgerufen wird
        try {
            dieSteuerung.geklicktAnmelden(pBenutzername, pPasswort);
            dasLoginFenster = null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void geklicktAbmelden() {
        try {
            dieSteuerung.geklicktAbmelden();
        } catch (Exception e) {
            zeigeMeldung("Fehler beim Abmelden");
        }
    }

    private void ausgewaehltEmpfaenger() {
        if (ausgewaehlteEmpfaenger.contains(txtEmpfaenger.getText())) {
            ausgewaehlteEmpfaenger.remove(txtEmpfaenger.getText());
        } else {
            ausgewaehlteEmpfaenger.add(txtEmpfaenger.getText());
        }
    }

    public void erfolgreichAbgemeldet() {
        zeigeFenstertitel("");
        logBtn.setText("anmelden");
        logBtn.setBounds(6, 317, 117, 29);
        contentPane.add(logBtn);
    }

    public void erfolgreichAngemeldet(String pBenutzername) {
        zeigeFenstertitel(pBenutzername);
        logBtn.setText("abmelden");
        logBtn.setBounds(6, 317, 117, 29);
        contentPane.add(logBtn);
    }

    private void logBtnAction() { //fuer einen Button, der an- und abmeldet
        if (dieSteuerung.istAngemeldet()) {
            geklicktAbmelden();
        } else {
            oeffneLoginFenster();
        }
    }

    private void geklicktLoeschen() {
        loescheEingabeTextnachricht();
    }

    private void geklicktSenden() {
        if (!ausgewaehlteEmpfaenger.isEmpty() && txtEingabeTextnachricht.getText() != null) {
            String[] empfaenger = (String[]) ausgewaehlteEmpfaenger.toArray();
            try {
                dieSteuerung.sendeTextnachricht(empfaenger, txtEingabeTextnachricht.getText());
                loescheEingabeTextnachricht();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loescheEingabeTextnachricht() {
        txtEingabeTextnachricht.setText("");
    }

    public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer) {
        model.clear();
        for (String benutzer : pAngemeldeteBenutzer) {
            model.addElement(benutzer);
        }
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
