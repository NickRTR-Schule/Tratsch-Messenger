package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

public class Steuerung
{
	private Netzwerk dasNetzwerk;
	private Benutzerschnittstelle dieBenutzerschnittstelle;

	public Steuerung(Benutzerschnittstelle pBenutzerschnittstellle)
	{
		dieBenutzerschnittstelle = pBenutzerschnittstellle;
		dasNetzwerk = new Netzwerk(this);
	}

	public void geaendertAngemeldeteBenutzer(String[] pAngemeldeteBenuter)
	{
		String[] angemeldeteBenutzer = pAngemeldeteBenuter;
		dieBenutzerschnittstelle.zeigeAngemeldeteBenutzer(angemeldeteBenutzer);
	}

	public void geklicktStarten()
	{
		dasNetzwerk.starte();
	}

	public void geklicktStoppen()
	{
		dasNetzwerk.stoppe();
	}

	public void zeigeMeldung(String pMeldung)
	{
		String meldung = pMeldung;
		dieBenutzerschnittstelle.zeigeMeldung(pMeldung);
	}
}
