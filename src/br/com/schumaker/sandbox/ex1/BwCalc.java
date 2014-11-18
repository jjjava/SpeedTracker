package br.com.schumaker.sandbox.ex1;

import java.io.*;
import java.net.*;

public class BwCalc {

    static class CalculateBw {

        public void calculateUploadBw() {
        }

        public float calculateDownloadRate(int waitTime) throws Exception {
            int bufferSize = 1;
            byte[] data = new byte[bufferSize]; // buffer
            BufferedInputStream in = new BufferedInputStream(new URL("https://www.google.co.in/").openStream());
            int count = 0;
            long startedAt = System.currentTimeMillis();
            long stoppedAt;
            float rate;
            while (((stoppedAt = System.currentTimeMillis()) - startedAt) < waitTime) {
                if (in.read(data, 0, bufferSize) != -1) {
                    count++;
                } else {
                    System.out.println("Finished");
                    break;
                }
            }
            in.close();
            rate = 1000 * (((float) count * bufferSize * 8 / (stoppedAt - startedAt))) / (1024 * 1024);//rate in Mbps
            return rate;
        }

        public float calculateAverageDownloadRate() throws Exception {
            int times[] = {100, 200, 300, 400, 500};
            float bw = 0, curBw;
            int i = 0, len = times.length;
            while (i < len) {
                curBw = calculateDownloadRate(times[i++]);
                bw += curBw;
                System.out.println("Current rate : " + Float.toString(curBw));
            }
            bw /= len;
            return bw;
        }
    }

    public static void main(String argc[]) throws Exception {
        CalculateBw c = new CalculateBw();
        System.out.println(Float.toString(c.calculateAverageDownloadRate()));
    }
}
