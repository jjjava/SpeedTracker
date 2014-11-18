
package br.com.schumaker.sandbox.ex3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author hudson.sales
 */
public class NewClass {

    volatile long totalDownloaded;
    long downloadStartTime;

    public NewClass() throws MalformedURLException, IOException {
        totalDownloaded = 0L;
        downloadStartTime = System.currentTimeMillis();
        int val;
        String buffer;
        BufferedInputStream bis = new BufferedInputStream(
                //                new URL(
                //                        "http://kernel.ubuntu.com/~kernel-ppa/mainline/v2.6.15/linux-headers-2.6.15-020615_2.6.15-020615_all.deb")
                //                        .openStream());
                new URL(
                        "http://miaibv91.mia.michelin.com:7032/reports/ViewData/SPD/encours/RPR_PDD_GLO.L1411185161096.20141118010442")
                .openStream());

        while ((val = bis.read(buffer, 0, 1024)) > 0) {
           // out.write(buffer, 0, val);
            totalDownloaded += val;
            fileSize -= val;
            if (fileSize < 1024) {
                val = (int) fileSize;
            }
        }

    }

    public float getDownloadSpeed() {
        long elapsedTime = System.currentTimeMillis() - downloadStartTime;
        return 1000f * totalDownloaded / elapsedTime;
    }

    public static void main(String[] args) {
    }
}
