package netzwerk;

import datenspeicherung.Konfiguration;
import gemeinsam.*;
import steuerung.Steuerung;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Netzwerk {

    private final Konfiguration dieKonfiguration;
    private final Steuerung dieSteuerung;
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;
    private boolean angemeldet = false;
    private String benutzername = "";

    public Netzwerk(Steuerung pSteuerung) throws IOException {
        dieSteuerung = pSteuerung;
        dieKonfiguration = new Konfiguration("localhost", 8080);
        socket = new Socket(dieKonfiguration.liesHost(), dieKonfiguration.liesPort()); //Throws Error
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
        final Thread inputThread = new Thread(() -> {
            try {
                final Botschaft botschaftIn = (Botschaft) inputStream.readObject();
                behandleBotschaft(botschaftIn);
            } catch (Exception ignored) {

            }
        });
        inputThread.start();
    }

    private void behandleBotschaft(Botschaft pBotschaft) {
        if (pBotschaft instanceof ServerBotschaftAngemeldeteBenutzer) {
        } else if (pBotschaft instanceof ServerBotschaftLoginNOK) {
        } else if (pBotschaft instanceof ServerBotschaftLoginOK) {
        } else if (pBotschaft instanceof ServerBotschaftLogoutErzwungen) {
        } else if (pBotschaft instanceof ServerBotschaftLogoutOK) {
        } else if (pBotschaft instanceof ServerBotschaftSendenTextnachrichtNOK) {
        } else if (pBotschaft instanceof ServerBotschaftTextnachricht) {
        }
    }

    public boolean istAngemeldet() {
        return angemeldet;
    }

    public void meldeAb() {
        benutzername = "";
        angemeldet = false;
    }

    public void meldeAn(String pBenutzername, String passwort) throws IOException {
        benutzername = pBenutzername;
        // TODO: change
        angemeldet = true;
        outputStream.writeObject(new ClientBotschaftLogin(pBenutzername, passwort));
    }

    public void schliesseVerbindung() throws IOException {
        outputStream.writeObject(new ClientBotschaftLogout(benutzername));
    }

    public void sendeTextnachricht(String[] pEmpfaenger, String pTextnachricht) throws IOException {
        for (String e : pEmpfaenger) {
            outputStream.writeObject(new ClientBotschaftSendenTextnachricht(benutzername, e, pTextnachricht));
        }
    }
}
