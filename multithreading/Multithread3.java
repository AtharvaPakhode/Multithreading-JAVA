package multithreading;

import java.util.Random;

import static java.lang.Thread.sleep;

// creating thread using Runnable interface --> way 2

public class Multithread3 {
    public static void main(String[] args) {
        new Thread(new Runnable(){

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Random ran = new Random();

                    sleep(ran.nextInt(1000)); // --> randomized sleep timer so the perticular thread
                    // --> is not wait for fix time
                    // --> sleep time is any time between 0-1000 ms
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            }
        }).start();


    }
}
