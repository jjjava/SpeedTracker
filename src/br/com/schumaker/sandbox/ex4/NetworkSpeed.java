package br.com.schumaker.sandbox.ex4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Hudson Schumaker
 */
public class NetworkSpeed {

    private StringBuffer content;
    private String arquivo = "";
    private String path = "http://macmagazine.com.br/forum/index.php?/topic/136886-novos-mac-mini-2014/page-2";

    public NetworkSpeed() {
        content = new StringBuffer();
    }

    public void getFile() {
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication("hudson.sales",
                        "michelin14".toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.28.128.15", 3128));
        try {
            System.out.println(path);
            long startTime = System.nanoTime(); // starting time of download
            URLConnection conn = new URL(path).openConnection(proxy);
            InputStream is = conn.getInputStream();
              System.out.println("lenght"+conn.getContentLength());
            FileOutputStream fos = new FileOutputStream("C:/Temp/" + "xxx.x");
            int umByte = 0;
            while ((umByte = is.read()) != -1) {
                fos.write(umByte);
            }
            is.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        for (int k = 0; k < 1; k++) {
            NetworkSpeed ns = new NetworkSpeed();
            ns.getFile();
        }
    }
}
