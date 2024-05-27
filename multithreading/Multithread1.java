package multithreading;

import static java.lang.Thread.sleep;

public class Multithread1 {

    /*
    new Thread() -->to make thread into new state
    start() -->to make thread into runnable state
    run() -->to make thread into running state

     */
    public static void main(String[] args) throws InterruptedException {
        Mycounter counter1 = new Mycounter(1);
        Mycounter counter2 = new Mycounter(2);
        long startTime = System.currentTimeMillis();
        counter1.start() ; /* or counter1.run();  --> when we use run processing time will be more
                            --> when we use start method as soon as the one thread is sleep for 500 ms
                            -->  the other thread in runnable state start running hence we got optimized time */
        System.out.println("*************************************************************");
        counter2.start(); ////or counter2.run()
        long endTime =System.currentTimeMillis();
        System.out.println("total time for processing: "+(endTime-startTime));
    }
}
class Mycounter extends Thread{
    private int ThreadNo ;

    public Mycounter(int ThreadNo){
        this.ThreadNo=ThreadNo;
    }
    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void countMe() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            sleep(500);
            System.out.println("ThreadNo: " + ThreadNo + " iteration is: " + i);
        }
    }
}
