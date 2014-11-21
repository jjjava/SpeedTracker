package br.com.schumaker.sandbox.ex3;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author hudson.sales
 */
public class NewClass {

    volatile long totalDownloaded;
    long downloadStartTime;
    private String path;

    public NewClass() throws MalformedURLException, IOException {
        final int BUFFER_SIZE = 1024; // size of the buffer
        byte[] data = new byte[BUFFER_SIZE]; // buffer
        totalDownloaded = 0L;
        downloadStartTime = System.currentTimeMillis();
        int val;
        path = "http://miaibv91.mia.michelin.com:7032/reports/ViewData/RDI/archiveRDI/RPR_PDV_GLO.L1411217553158.20141121004711";
        BufferedInputStream bis = new BufferedInputStream(new URL(path).openStream());
        URLConnection conn = new URL(path).openConnection();
        System.out.println("size: " + (conn.getContentLength()/1024.0)/1024.0);
        FileOutputStream fos = new FileOutputStream("C:/Temp/" + "xxx.txt");

        while ((val = bis.read(data, 0, 1024)) > 0) {
            fos.write(data);
            totalDownloaded += val;
            long elapsedTime = System.currentTimeMillis() - downloadStartTime;
            float r = (1000f * totalDownloaded / elapsedTime);
            System.out.println("rate:" + (r/1024));
        }
        bis.close();
        fos.close();
    }

    public float getDownloadSpeed() {
        long elapsedTime = System.currentTimeMillis() - downloadStartTime;
        return 1000f * totalDownloaded / elapsedTime;
    }

    public static void main(String[] args) throws IOException {
        NewClass nc = new NewClass();
    }
}
