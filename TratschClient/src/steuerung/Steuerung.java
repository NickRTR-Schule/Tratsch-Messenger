package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

import java.io.IOException;

public class Steuerung {
	
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Netzwerk dasNetzwerk = new Netzwerk(this);
	
	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle) {
		dieBenutzerschnittstelle = pBenutzerschnittstelle;
	}

	public void erfolgreichAbgemeldet() {
		
	}
	
	public void erfolgreichAngemeldet(String pBenutzename) {
		
	}
	
	public void erhaltenTextnachricht(String pAbsender, String pEmpfaenger, String pTextnachricht) {
		dieBenutzerschnittstelle.zeigeTextnachricht(pAbsender, pEmpfaenger, pTextnachricht);
	}
	
	public void geklicktAbmelden() {
		dasNetzwerk.meldeAb();
	}
	
	public void geklicktAnmelden(String pBenutzername, String pPassword) {
		
	}
	
	public boolean istAngemeldet() {
		
	}
	
	public void sendeTextnachricht(String[] pEmpfaenger, String pTextnachricht) {
		dasNetzwerk.sendeTextnachricht(pEmpfaenger, pTextnachricht);
	}
	
	public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer) {
		
	}
	
	public void zeigeMeldung(String pMeldung) {
		dieBenutzerschnittstelle.zeigeMeldung(pMeldung);
	}
}
