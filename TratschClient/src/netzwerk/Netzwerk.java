package netzwerk;

import datenspeicherung.Konfiguration;
import gemeinsam.*;
import steuerung.Steuerung;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Netzwerk {

    private final Logger logger = Logger.getLogger(Netzwerk.class.getName());
    private final Steuerung dieSteuerung;
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private boolean angemeldet = false;
    private String benutzername = "";

    public Netzwerk(Steuerung pSteuerung) throws IOException {
        dieSteuerung = pSteuerung;
        final Konfiguration dieKonfiguration = new Konfiguration("localhost", 6666);
        socket = new Socket(dieKonfiguration.liesHost(), dieKonfiguration.liesPort());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        final Thread inputThread = new Thread(() -> {
            while (true) {
                try {
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    final Botschaft botschaftIn = (Botschaft) inputStream.readObject();
                    SwingUtilities.invokeLater(() -> {
                        try {
                            behandleBotschaft(botschaftIn);
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, e.getMessage(), e);
                        }
                    });
                } catch (Exception e) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
                }
            }
        });
        inputThread.start();
    }

    private void behandleBotschaft(Botschaft pBotschaft) throws IOException {
        if (pBotschaft instanceof ServerBotschaftAngemeldeteBenutzer) {
            final String[] a = new String[((ServerBotschaftAngemeldeteBenutzer) pBotschaft).liesAngemeldeteBenutzer().size()];
            ((ServerBotschaftAngemeldeteBenutzer) pBotschaft).liesAngemeldeteBenutzer().toArray(a);
            dieSteuerung.zeigeAngemeldeteBenutzer(a);
        } else if (pBotschaft instanceof ServerBotschaftLoginNOK) {
            dieSteuerung.zeigeMeldung("Login nicht erfolgreich");
        } else if (pBotschaft instanceof ServerBotschaftLoginOK) {
            dieSteuerung.erfolgreichAngemeldet(benutzername);
        } else if (pBotschaft instanceof ServerBotschaftLogoutErzwungen) {
            schliesseVerbindung();
        } else if (pBotschaft instanceof ServerBotschaftLogoutOK) {
            schliesseVerbindung();
            benutzername = "";
            angemeldet = false;
            dieSteuerung.erfolgreichAbgemeldet();
            dieSteuerung.zeigeMeldung("Logout erfolgreich");
        } else if (pBotschaft instanceof ServerBotschaftSendenTextnachrichtNOK) {
            dieSteuerung.zeigeMeldung("Senden nicht erfolgreich");
        } else if (pBotschaft instanceof ServerBotschaftTextnachricht) {
            dieSteuerung.erhaltenTextnachricht(((ServerBotschaftTextnachricht) pBotschaft).liesAbsender(), ((ServerBotschaftTextnachricht) pBotschaft).liesEmpfaenger(), ((ServerBotschaftTextnachricht) pBotschaft).liesTextnachricht());
        }
    }

    public boolean istAngemeldet() {
        return angemeldet;
    }

    public void meldeAb() throws IOException {
        outputStream.writeObject(new ClientBotschaftLogout(benutzername));
    }

    public void meldeAn(String pBenutzername, String passwort) throws IOException {
        benutzername = pBenutzername;
        // TODO: change
        angemeldet = true;
        outputStream.writeObject(new ClientBotschaftLogin(pBenutzername, passwort));
    }

    public void schliesseVerbindung() throws IOException {
        outputStream.writeObject(new ClientBotschaftLogout(benutzername));
        socket.close();
    }

    public void sendeTextnachricht(String[] pEmpfaenger, String pTextnachricht) throws IOException {
        for (String e : pEmpfaenger) {
            outputStream.writeObject(new ClientBotschaftSendenTextnachricht(benutzername, e, pTextnachricht));
        }
    }
}
