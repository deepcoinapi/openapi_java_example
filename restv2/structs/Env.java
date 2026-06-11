package structs;

/**
 * Environment configuration
 */
public class Env {
    private String url;
    private String key;
    private String secretKey;
    private String passphrase;

    public Env() {}

    public Env(String url, String key, String secretKey, String passphrase) {
        this.url = url;
        this.key = key;
        this.secretKey = secretKey;
        this.passphrase = passphrase;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getSecretKey() { return secretKey; }
    public void setSecretKey(String secretKey) { this.secretKey = secretKey; }
    public String getPassphrase() { return passphrase; }
    public void setPassphrase(String passphrase) { this.passphrase = passphrase; }
}
