package netzwerk;

import datenspeicherung.Benutzerliste;
import gemeinsam.*;
import steuerung.Steuerung;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Netzwerk {
    private final Steuerung s;
    public T1 m;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Benutzerliste b;
    private HashMap<String, ObjectOutputStream> user;

    public Netzwerk(Steuerung ps) {
        this.s = ps;
    }

    public void bearbeiteVerbindung() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                Botschaft f = (Botschaft) in.readObject();

                if (f instanceof ClientBotschaftLogin) {
                    String name = ((ClientBotschaftLogin) f).liesBenutzername();
                    String pwd = ((ClientBotschaftLogin) f).liesPassword();

                    // validate name and pwd
                    if (this.b.istGueltig(name, pwd)) {
                        out.writeObject(new ServerBotschaftLoginOK());
                    } else {
                        out.writeObject(new ServerBotschaftLoginNOK("Wrong username and/or password"));
                    }

                    // jetzt an handler übergeben
                    // neuen thread starten und an handler uebergeben
                    class MachWasThread extends Thread {
                        private final ObjectInputStream client_in;
                        private final ObjectOutputStream client_out;
                        private final String user_name;

                        public MachWasThread(String name, ObjectInputStream in, ObjectOutputStream out) {
                            this.client_in = in;
                            this.client_out = out;
                            this.user_name = name;
                        }

                        public void run() {
                            while (true) {
                                try {
                                    Botschaft k = (Botschaft) this.client_in.readObject();

                                    // switch all botschaften
                                    if (k instanceof ClientBotschaftLogout) {
                                        // "Benutzername abgemeldet" anzeigen
                                        user.remove(this.user_name);
                                        this.client_out.writeObject(new ServerBotschaftLogoutOK());
                                        // liste der angemeldeten Benutzer hat sich geändert (array aller angemeldeten Benutzer an steuerung schicken)
                                        sendeAnAlleClients(new ServerBotschaftAngemeldeteBenutzer(new ArrayList<String>(user.keySet())));
                                        break;
                                    } else if (k instanceof ClientBotschaftSendenTextnachricht c) {
                                        this.client_out.writeObject(new ServerBotschaftTextnachricht(c.liesAbsender(), c.liesEmpfaenger(), c.liesTextnachricht()));

                                        if (user.containsValue(c.liesEmpfaenger())) {
                                            user.get(c.liesEmpfaenger()).writeObject(new ServerBotschaftTextnachricht(c.liesAbsender(), c.liesEmpfaenger(), c.liesTextnachricht()));
                                        } else {
                                            this.client_out.writeObject(new ServerBotschaftSendenTextnachrichtNOK("Lorem Ipsum dolor et sumit"));
                                        }
                                    }
                                } catch (ClassNotFoundException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                    user.put(name, out);

                    MachWasThread machWasThread = new MachWasThread(name, in, out);
                    machWasThread.start();
                } else {
                    break;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void sendeAnAlleClients(Botschaft pBotschaft) {
        for (String i : user.keySet()) {
            try {
                user.get(i).writeObject(pBotschaft);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void starte() {
        this.b = new Benutzerliste();
        try {
            serverSocket = new ServerSocket(6666);
            m = new T1();
            m.start();
            s.zeigeMeldung("Server wurde gestartet");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("removal")
    public void stoppe() {
        try {
            m.stop();
            if (user != null) {
                for (ObjectOutputStream i : user.values()) {
                    i.close();
                }
                s.zeigeMeldung("users have been fucked");
            }
            serverSocket.close();
            s.zeigeMeldung("Server wurde gestoppt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class T1 extends Thread {
        public void run() {
            bearbeiteVerbindung();
        }
    }
}
