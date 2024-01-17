package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

import java.io.IOException;

public class Steuerung 
{
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Netzwerk dasNetzwerk;
	
	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle) throws IOException {
		dieBenutzerschnittstelle = pBenutzerschnittstelle;
		dasNetzwerk = new Netzwerk(this);
	}

	public void geklicktAbmelden()
	{
		dasNetzwerk.meldeAb();
	}

}
