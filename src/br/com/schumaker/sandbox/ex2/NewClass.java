/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
                        "http://miaibv91.mia.michelin.com:7032/reports/ViewData/CTG/encours/RWH_ART.L1411166565890.20141116210516")
                        .openStream());
        int dataRead = 0; // data read in each try
        long startTime = System.nanoTime(); // starting time of download
        while ((dataRead = in.read(data, 0, 1024)) > 0) {
            totalDownload += dataRead; // adding data downloaded to total data
        }
        /* download rate in bytes per second */
        float bytesPerSec = totalDownload
                / ((System.nanoTime() - startTime) / 1000000000);
        System.out.println(bytesPerSec + " Bps");
        /* download rate in kilobytes per second */
        float kbPerSec = bytesPerSec / (1024);
        System.out.println(kbPerSec + " KBps ");
        /* download rate in megabytes per second */
        float mbPerSec = kbPerSec / (1024);
        System.out.println(mbPerSec + " MBps ");
    }
}
