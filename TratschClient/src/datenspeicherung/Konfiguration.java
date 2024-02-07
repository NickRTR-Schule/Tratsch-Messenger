package datenspeicherung;

public class Konfiguration {
    private final String host;
    private final int port;

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
