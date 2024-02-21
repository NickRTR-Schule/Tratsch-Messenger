package benutzerschnittstelle;

import steuerung.Steuerung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Benutzerschnittstelle extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextArea txtMeldungen;
    private final JButton btnStarten;
    private final JButton btnStoppen;
    private final JTextArea txtAngemeldeteBenutzer;
    private final Steuerung dieSteuerung;

    /**
     * Create the frame.
     */
    @SuppressWarnings("deprecation")
    public Benutzerschnittstelle() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 230);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtMeldungen = new JTextArea();
        txtMeldungen.setBounds(270, 11, 658, 173);
        txtMeldungen.disable();
        contentPane.add(txtMeldungen);

        btnStarten = new JButton("start server");
        btnStarten.addActionListener(e -> geklicktStarten());
        btnStarten.setBounds(10, 12, 250, 23);
        contentPane.add(btnStarten);

        btnStoppen = new JButton("stop server");
        btnStoppen.setEnabled(false);
        btnStoppen.addActionListener(e -> geklicktStoppen());
        btnStoppen.setBounds(10, 46, 250, 23);
        contentPane.add(btnStoppen);

        JLabel lblAngemeldeteBenutzer = new JLabel("Angemeldete Benutzer:");
        lblAngemeldeteBenutzer.setBounds(20, 80, 240, 14);
        contentPane.add(lblAngemeldeteBenutzer);

        txtAngemeldeteBenutzer = new JTextArea();
        txtAngemeldeteBenutzer.setBounds(10, 105, 250, 79);
        txtAngemeldeteBenutzer.disable();
        contentPane.add(txtAngemeldeteBenutzer);
        dieSteuerung = new Steuerung(this);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Benutzerschnittstelle frame = new Benutzerschnittstelle();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void geklicktStoppen() {
        dieSteuerung.geklicktStoppen();
        btnStoppen.setEnabled(false);
        btnStarten.setEnabled(true);

    }

    private void geklicktStarten() {
        dieSteuerung.geklicktStarten();
        btnStarten.setEnabled(false);
        btnStoppen.setEnabled(true);
    }

    public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer) {
        StringBuilder benutzer = new StringBuilder();
        for (String s : pAngemeldeteBenutzer) {
            benutzer.append(s);
            benutzer.append(", ");
        }
        txtAngemeldeteBenutzer.setText(benutzer.toString());
    }

    public void zeigeMeldung(String pMeldung) {
        DateFormat formatter = new SimpleDateFormat();
        String date = formatter.format(Calendar.getInstance().getTime());
        txtMeldungen.append(date + ": " + pMeldung + " \n");

    }

}
