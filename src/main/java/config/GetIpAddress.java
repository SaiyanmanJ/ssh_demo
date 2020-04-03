package config;

import java.net.Inet4Address;

public class GetIpAddress {
    private String ip;

    public String getIp() throws Exception {
        Inet4Address inet4Address = (Inet4Address) Inet4Address.getLocalHost();
        ip = inet4Address.getHostAddress();
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
