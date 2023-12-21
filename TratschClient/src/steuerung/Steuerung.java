package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

public class Steuerung 
{
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Netzwerk dasNetzwerk;
	
	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		dieBenutzerschnittstelle = pBenutzerschnittstelle;
		dasNetzwerk = new Netzwerk(this);
	}

	public void geklicktAbmelden()
	{
		dasNetzwerk.meldeAb();
	}

}
