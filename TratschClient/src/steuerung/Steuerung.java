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

	public void geklicktAnmelden(String pBenutzername, String pPasswort)
	{
		try
		{
			dasNetzwerk.meldeAn(pBenutzername, pPasswort);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
