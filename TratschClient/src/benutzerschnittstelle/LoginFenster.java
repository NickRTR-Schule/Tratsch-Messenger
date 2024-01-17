package benutzerschnittstelle;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFenster extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private JPasswordField txtPassword;
	private JButton btnAnmelden;
	private JButton btnAbbrechen;
	private boolean geklicktAnmelden;

	private Benutzerschnittstelle dieBenutzerschnittstelle;

	private static final long serialVersionUID = 1L;

	public LoginFenster(Benutzerschnittstelle pBenutzerschnittstelle)
	{
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
		btnAnmelden.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
//				System.out.println("Test");
				geklicktAnmelden();
			}
		});
		btnAnmelden.setBounds(7, 138, 117, 29);
		contentPanel.add(btnAnmelden);

		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				geklicktAbbrechen();
			}
		});
		btnAbbrechen.setBounds(7, 181, 117, 29);
		contentPanel.add(btnAbbrechen);
	}

	private void geklicktAbbrechen()
	{
		this.dispose();
	}

	private void geklicktAnmelden()
	{
		System.out.println("Test");
		String benutzername = txtBenutzername.getText();
		String passwort = new String(txtPassword.getPassword());
		dieBenutzerschnittstelle.geklicktAnmelden(benutzername, passwort);
		
		this.dispose();
	}

	public boolean hatGeklicktAnmelden()
	{
		return geklicktAnmelden;
	}
}
