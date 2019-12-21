
package af.asr.kyc.infrastructure.configuration.data;

public class SMTPCredentialsData {

    private final String username;
    private final String password;
    private final String host;
    private final String port;
    private final boolean useTLS;
    private final String fromEmail;
    private final String fromName;

    public SMTPCredentialsData(final String username, final String password, final String host, final String port, final boolean useTLS, String fromEmail, String fromName) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.useTLS = useTLS;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public boolean isUseTLS() {
        return useTLS;
    }

    public String getFromEmail() {
        return fromEmail != null ?fromEmail :username;
    }

    public String getFromName() {
        return fromName != null ?fromName :username;
    }
}
