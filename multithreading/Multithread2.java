package multithreading;
import java.util.Random;

import static java.lang.Thread.sleep;

// creating thread using Runnable interface --> way 1
class Mycounter1 implements Runnable{
    private int ThreadNo ;

    public Mycounter1(int ThreadNo){
        this.ThreadNo=ThreadNo;
    }


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
            System.out.println("ThreadNo: " + ThreadNo + " iteration is: " + i);
        }
    }
}

public class Multithread2 {
    public static void main(String[] args) {
        Mycounter1 m1 = new Mycounter1(1);
        Mycounter1 m2 = new Mycounter1(2);
        Thread thread1 = new Thread(m1);
        Thread thread2 = new Thread(m2);
        thread1.start();
        thread2.start();
    }
}
/*

ThreadNo: 1 iteration is: 0
ThreadNo: 1 iteration is: 1
ThreadNo: 1 iteration is: 2
ThreadNo: 2 iteration is: 0
ThreadNo: 1 iteration is: 3
ThreadNo: 1 iteration is: 4
ThreadNo: 2 iteration is: 1
ThreadNo: 2 iteration is: 2
ThreadNo: 1 iteration is: 5
ThreadNo: 1 iteration is: 6
ThreadNo: 2 iteration is: 3
ThreadNo: 1 iteration is: 7
ThreadNo: 2 iteration is: 4
ThreadNo: 2 iteration is: 5
ThreadNo: 1 iteration is: 8
ThreadNo: 2 iteration is: 6
ThreadNo: 1 iteration is: 9
ThreadNo: 2 iteration is: 7
ThreadNo: 2 iteration is: 8
ThreadNo: 2 iteration is: 9

the output will be randomized like this

 */