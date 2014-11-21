package br.com.schumaker.sandbox.ex3;

import java.io.BufferedInputStream;
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
        path = "http://miaibv91.mia.michelin.com:7032/reports/ExtractsTWS/DumpJobs/Dump_jobs_RCTGADS0_110923_0700.txt"; 
        BufferedInputStream bis = new BufferedInputStream(new URL(path).openStream());
        URLConnection conn = new URL(path).openConnection();
        System.out.println("size"+conn.getContentLength());
        while ((val = bis.read(data, 0, 1024)) > 0) {
            // out.write(buffer, 0, val);
            totalDownloaded += val;
            long elapsedTime = System.currentTimeMillis() - downloadStartTime;
            System.out.println("rate:" + (1000f * totalDownloaded / elapsedTime));
        }
    }

    public float getDownloadSpeed() {
        long elapsedTime = System.currentTimeMillis() - downloadStartTime;
        return 1000f * totalDownloaded / elapsedTime;
    }

    public static void main(String[] args) throws IOException {
        NewClass nc = new NewClass();
    }
}
