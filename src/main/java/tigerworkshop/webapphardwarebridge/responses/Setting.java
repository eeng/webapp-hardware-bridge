package tigerworkshop.webapphardwarebridge.responses;

import java.util.HashMap;

public class Setting {
    String address = "127.0.0.1";
    String bind = "0.0.0.0";
    int port = 12212;
    boolean fallbackToDefaultPrinter = false;

    HashMap<String, Object> authentication = new HashMap<String, Object>() {{
        put("enabled", false);
        put("token", "");
    }};

    HashMap<String, Object> tls = new HashMap<String, Object>() {{
        put("enabled", false);
        put("selfSigned", true);
        put("cert", "tls/default-cert.pem");
        put("key", "tls/default-key.pem");
        put("caBundle", "");
    }};

    HashMap<String, Object> cloudProxy = new HashMap<String, Object>() {{
        put("enabled", false);
        put("url", "ws://127.0.0.1:22212");
        put("timeout", 30);
    }};

    HashMap<String, String> printers = new HashMap<>();
    HashMap<String, String> serials = new HashMap<>();

    public String getAddress() {
        return address;
    }

    public String getBind() {
        return bind;
    }

    public int getPort() {
        return port;
    }

    public Boolean getFallbackToDefaultPrinter() {
        return fallbackToDefaultPrinter;
    }

    public Boolean getAuthenticationEnabled() {
        return (Boolean) authentication.get("enabled");
    }

    public String getAuthenticationToken() {
        return (String) authentication.get("token");
    }

    public Boolean getTLSEnabled() {
        return (boolean) tls.get("enabled");
    }

    public Boolean getTLSSelfSigned() {
        return (Boolean) tls.get("selfSigned");
    }

    public String getTLSCert() {
        return (String) tls.get("cert");
    }

    public String getTLSKey() {
        return (String) tls.get("key");
    }

    public String getTLSCaBundle() {
        return (String) tls.get("caBundle");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTLSCaBundle(String value) {
        tls.put("caBundle", value);
    }

    public void setCloudProxyEnabled(Boolean value) {
        this.cloudProxy.put("enabled", value);
    }

    public void setCloudProxyUrl(String value) {
        this.cloudProxy.put("url", value);
    }

    public Double getCloudProxyTimeout() {
        return cloudProxy.containsKey("timeout") ? (Double) cloudProxy.get("timeout") : 30;
    }

    public void setAuthenticationEnabled(Boolean value) {
        authentication.put("enabled", value);
    }

    public void setAuthenticationToken(String value) {
        authentication.put("token", value);
    }

    public void setTLSSelfSigned(Boolean value) {
        tls.put("selfSigned", value);
    }

    public void setTLSCert(String value) {
        tls.put("cert", value);
    }

    public void setTLSKey(String value) {
        tls.put("key", value);
    }

    public void setTLSEnabled(Boolean value) {
        tls.put("enabled", value);
    }

    public Boolean getCloudProxyEnabled() {
        return (boolean) cloudProxy.get("enabled");
    }

    public String getCloudProxyUrl() {
        return (String) cloudProxy.get("url");
    }

    public void setCloudProxyTimeout(Double value) {
        this.cloudProxy.put("timeout", value);
    }

    public HashMap<String, String> getPrinters() {
        return printers;
    }

    public void setPrinters(HashMap<String, String> printers) {
        this.printers = printers;
    }

    public void setFallbackToDefaultPrinter(boolean fallbackToDefaultPrinter) {
        this.fallbackToDefaultPrinter = fallbackToDefaultPrinter;
    }

    public HashMap<String, String> getSerials() {
        return serials;
    }

    public void setSerials(HashMap<String, String> serials) {
        this.serials = serials;
    }

    public String getUri() {
        return (getTLSEnabled() ? "wss" : "ws") + "://" + getAddress() + ":" + getPort();
    }
}