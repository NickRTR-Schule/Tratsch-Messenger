package benutzerschnittstelle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;


public class LoginFenster extends JDialog {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private final JTextField txtBenutzername;
    private final JPasswordField txtPassword;
    private final JButton btnAnmelden;
    private final JButton btnAbbrechen;
    private final Benutzerschnittstelle dieBenutzerschnittstelle;
    private boolean geklicktAnmelden;

    public LoginFenster(Benutzerschnittstelle pBenutzerschnittstelle) {
        dieBenutzerschnittstelle = pBenutzerschnittstelle;

        setTitle("Anmeldung");
        setBounds(100, 100, 149, 245);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblBenutzername = new JLabel("Benutzername");
        lblBenutzername.setBounds(6, 6, 118, 16);
        contentPanel.add(lblBenutzername);
        txtBenutzername = new JTextField();
        txtBenutzername.setBounds(6, 34, 130, 26);
        contentPanel.add(txtBenutzername);
        txtBenutzername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(6, 72, 61, 16);
        contentPanel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(6, 100, 130, 26);
        contentPanel.add(txtPassword);

        btnAnmelden = new JButton("anmelden");
        btnAnmelden.addActionListener(e -> geklicktAnmelden());
        btnAnmelden.setBounds(7, 138, 117, 29);
        contentPanel.add(btnAnmelden);

        btnAbbrechen = new JButton("abbrechen");
        btnAbbrechen.addActionListener(e -> geklicktAbbrechen());
        btnAbbrechen.setBounds(7, 181, 117, 29);
        contentPanel.add(btnAbbrechen);
    }

    private void geklicktAbbrechen() {
        this.dispose();
    }

    private void geklicktAnmelden() {
        if (txtBenutzername.getText().isEmpty() || txtPassword.getPassword() == null) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie einen Benutzernamen und ein Passwort ein", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String benutzername = txtBenutzername.getText();
            String passwort = new String(txtPassword.getPassword());
            dieBenutzerschnittstelle.geklicktAnmelden(benutzername, passwort);
            this.dispose();
        }
    }

    public boolean hatGeklicktAnmelden() {
        return geklicktAnmelden;
    }
    
    public String liesBenutzername()
    {
    return txtBenutzername.getText();	
    }
    
    public String liesPassword()
    {
    	return new String(txtPassword.getPassword());
    }
}
