package benutzerschnittstelle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import steuerung.Steuerung;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Benutzerschnittstelle extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtMeldungen;
	private JButton btnStarten;
	private JButton btnStoppen;
	private JLabel lblAngemeldeteBenutzer;
	private JTextArea txtAngemeldeteBenutzer;
	private Steuerung dieSteuerung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
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
	@SuppressWarnings("deprecation")
	public Benutzerschnittstelle()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtMeldungen = new JTextArea();
		txtMeldungen.setBounds(270, 11, 658, 173);
		txtMeldungen.disable();
		contentPane.add(txtMeldungen);

		btnStarten = new JButton("start server");
		btnStarten.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				geklicktStarten();
			}
		});
		btnStarten.setBounds(10, 12, 250, 23);
		contentPane.add(btnStarten);

		btnStoppen = new JButton("stop server");
		btnStoppen.setEnabled(false);
		btnStoppen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				geklicktStoppen();
			}
		});
		btnStoppen.setBounds(10, 46, 250, 23);
		contentPane.add(btnStoppen);

		lblAngemeldeteBenutzer = new JLabel("Angemeldete Benutzer:");
		lblAngemeldeteBenutzer.setBounds(20, 80, 240, 14);
		contentPane.add(lblAngemeldeteBenutzer);

		txtAngemeldeteBenutzer = new JTextArea();
		txtAngemeldeteBenutzer.setBounds(10, 105, 250, 79);
		txtAngemeldeteBenutzer.disable();
		contentPane.add(txtAngemeldeteBenutzer);
		dieSteuerung = new Steuerung(this);
	}

	private void geklicktStoppen()
	{
		dieSteuerung.geklicktStoppen();
		btnStoppen.setEnabled(false);
		btnStarten.setEnabled(true);

	}

	private void geklicktStarten()
	{
		dieSteuerung.geklicktStarten();
		btnStarten.setEnabled(false);
		btnStoppen.setEnabled(true);
	}

	public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer)
	{
		String benutzer = "";
		for (int i = 0; i < pAngemeldeteBenutzer.length; i++)
		{
			benutzer += pAngemeldeteBenutzer[i];
			benutzer += ", ";
		}
		txtAngemeldeteBenutzer.setText(benutzer);
	}

	public void zeigeMeldung(String pMeldung)
	{
		DateFormat formatter = new SimpleDateFormat();
		String date = formatter.format(Calendar.getInstance().getTime());
		txtMeldungen.append(date +": " + pMeldung + " \n");
		
	}

}
