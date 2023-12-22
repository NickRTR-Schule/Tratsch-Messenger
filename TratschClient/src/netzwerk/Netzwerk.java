package netzwerk;

import datenspeicherung.Konfiguration;
import gemeinsam.Botschaft;
import gemeinsam.ClientBotschaftLogin;
import gemeinsam.ClientBotschaftSendenTextnachricht;
import gemeinsam.ServerBotschaftLoginNOK;
import steuerung.Steuerung;

import java.io.*;
import java.net.Socket;

public class Netzwerk {

    private Steuerung dieSteuerung;

    private final Konfiguration dieKonfiguration;

    private boolean angemeldet = false;

    private String benutzername = "";

    private Socket socket;

    private ObjectOutputStream outputStream;

    private ObjectInputStream inputStream;

    public Netzwerk(Steuerung pSteuerung) throws IOException {
        dieSteuerung = pSteuerung;
        dieKonfiguration = new Konfiguration("localhost", 8080);
        socket = new Socket(dieKonfiguration.liesHost(), dieKonfiguration.liesPort());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
    }

    private void behandleBotschaft(Botschaft pBotschaft) {
        switch (pBotschaft.getClass()) {
            case ServerBotschaftLoginNOK.class:
                break;
        }
    }

    public boolean istAngemeldet() {
        return angemeldet;
    }

    public void meldeAb() {
        angemeldet = false;
    }

    public void meldeAn(String pBenutzername, String passwort) throws IOException {
        benutzername = pBenutzername;
        angemeldet = true;
        outputStream.writeObject(new ClientBotschaftLogin(pBenutzername, passwort));
    }

    public void schliesseVerbindung() {
        try {
            socket.close();
        } catch (IOException e) {
            // TODO-js: Add Exception Code
        }
    }

    public void sendeTextnachricht(String[] pEmpfaenger, String pTextnachricht) throws IOException {
        for (String e : pEmpfaenger) {
            outputStream.writeObject(new ClientBotschaftSendenTextnachricht(benutzername, e, pTextnachricht));
        }
    }
}
