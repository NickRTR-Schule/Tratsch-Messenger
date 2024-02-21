package steuerung;

import benutzerschnittstelle.Benutzerschnittstelle;
import netzwerk.Netzwerk;

public class Steuerung {
    private final Netzwerk dasNetzwerk;
    private final Benutzerschnittstelle dieBenutzerschnittstelle;

    public Steuerung(Benutzerschnittstelle pBenutzerschnittstellle) {
        dieBenutzerschnittstelle = pBenutzerschnittstellle;
        dasNetzwerk = new Netzwerk(this);
    }

    public void geaendertAngemeldeteBenutzer(String[] pAngemeldeteBenuter) {
        dieBenutzerschnittstelle.zeigeAngemeldeteBenutzer(pAngemeldeteBenuter);
    }

    public void geklicktStarten() {
        dasNetzwerk.starte();
    }

    public void geklicktStoppen() {
        dasNetzwerk.stoppe();
    }

    public void zeigeMeldung(String pMeldung) {
        dieBenutzerschnittstelle.zeigeMeldung(pMeldung);
    }
}
