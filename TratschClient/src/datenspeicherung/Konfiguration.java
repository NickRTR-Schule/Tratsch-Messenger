package datenspeicherung;

public class Konfiguration {
    private String host;
    private int port;

    public Konfiguration(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String liesHost() {
        return host;
    }

    public int liesPort() {
        return port;
    }
}
