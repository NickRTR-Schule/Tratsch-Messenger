package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

import java.io.IOException;

public class Steuerung {

    private final Benutzerschnittstelle dieBenutzerschnittstelle;
    private final Netzwerk dasNetzwerk;

    public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle) throws IOException {
        dieBenutzerschnittstelle = pBenutzerschnittstelle;
        dasNetzwerk = new Netzwerk(this);
    }

    public void erfolgreichAbgemeldet() {
        dieBenutzerschnittstelle.erfolgreichAbgemeldet();
    }

    public void erfolgreichAngemeldet(String pBenutzename) {
        dieBenutzerschnittstelle.erfolgreichAngemeldet(pBenutzename);
    }

    public void erhaltenTextnachricht(String pAbsender, String pEmpfaenger, String pTextnachricht) {
        dieBenutzerschnittstelle.zeigeTextnachricht(pAbsender, pEmpfaenger, pTextnachricht);
    }

    public void geklicktAbmelden() {
        dasNetzwerk.meldeAb();
    }

    public boolean istAngemeldet() {
        return dasNetzwerk.istAngemeldet();
    }

    public void sendeTextnachricht(String[] pEmpfaenger, String pTextnachricht) throws IOException {
        dasNetzwerk.sendeTextnachricht(pEmpfaenger, pTextnachricht);
    }

    public void zeigeAngemeldeteBenutzer(String[] pAngemeldeteBenutzer) {
        dieBenutzerschnittstelle.zeigeAngemeldeteBenutzer(pAngemeldeteBenutzer);
    }

    public void zeigeMeldung(String pMeldung) {
        dieBenutzerschnittstelle.zeigeMeldung(pMeldung);
    }

    public void geklicktAnmelden(String pBenutzername, String pPasswort) throws IOException {
        dasNetzwerk.meldeAn(pBenutzername, pPasswort);
    }
}
