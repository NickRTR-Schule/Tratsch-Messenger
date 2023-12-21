package netzwerk;

import steuerung.Steuerung;

public class Netzwerk {

	private Steuerung dieSteuerung;
	
	private boolean angemeldet;
	
	public Netzwerk(Steuerung pSteuerung)
	{
		dieSteuerung = pSteuerung;
		
		angemeldet = false;
	}

	public void meldeAb()
	{
		angemeldet = false;
		schliesseVerbindung();
	}
	
	private void schliesseVerbindung()
	{
	}
	
	private boolean istAngemeldet()
	{
		return angemeldet;
	}
}
