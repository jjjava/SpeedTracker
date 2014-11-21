package br.com.schumaker.sandbox.ex2;

import java.io.BufferedInputStream;
import java.net.URL;

/**
 *
 * @author hudson.sales
 */
public class NewClass {

    public static void main(String argc[]) throws Exception {
        long totalDownload = 0; // total bytes downloaded
        final int BUFFER_SIZE = 1024; // size of the buffer
        byte[] data = new byte[BUFFER_SIZE]; // buffer
        BufferedInputStream in = new BufferedInputStream(
                //                new URL(
                //                        "http://kernel.ubuntu.com/~kernel-ppa/mainline/v2.6.15/linux-headers-2.6.15-020615_2.6.15-020615_all.deb")
                //                        .openStream());
                new URL(
                        "http://miaibv91.mia.michelin.com:7032/reports/ExtractsTWS/DumpJobs/Dump_jobs_RCTGADS0_110923_0700.txt")
                .openStream());
        int dataRead = 0; // data read in each try
        long startTime = System.nanoTime(); // starting time of download
        System.out.println(startTime);
        while ((dataRead = in.read(data, 0, 1024)) > 0) {
            totalDownload += dataRead; // adding data downloaded to total data
            System.out.println(System.nanoTime() - startTime);

//            if (totalDownload >= 1024) {
//                float bytesPerSec = totalDownload / ((System.nanoTime() - startTime) / 1000000000);
//                float kbPerSec = bytesPerSec / (1024);
//                System.out.println(kbPerSec + " KBps ");
//            }
            System.out.println(totalDownload);
        }
        /* download rate in bytes per second */
        float bytesPerSec = totalDownload  / ((System.nanoTime() - startTime) / 1000000000);
        System.out.println(bytesPerSec + " Bps");
        /* download rate in kilobytes per second */
        float kbPerSec = bytesPerSec / (1024);
        System.out.println(kbPerSec + " KBps ");
        /* download rate in megabytes per second */
        float mbPerSec = kbPerSec / (1024);
        System.out.println(mbPerSec + " MBps ");
    }
}
