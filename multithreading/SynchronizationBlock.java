package multithreading;

public class SynchronizationBlock {
    public static void main(String[] args) {
        Brackets1 b = new Brackets1();
        Brackets1 b1 = new Brackets1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {

                    try {
                        b.generate();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                long endTime = System.currentTimeMillis();
                System.out.println("total time required by thread 01: "+(endTime-startTime));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {

                    try {
                        b.generate();
                        /*
                                --> the synchronization is based on object. so if we try b1.generate()
                                    sync may be failed st soe instace.
                         */
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                long endTime = System.currentTimeMillis();
                System.out.println("total time required by thread 01: "+(endTime-startTime));
            }
        }).start();
    }
}
class Brackets1{
    private Object LOCK = "lock";

    /*
       --> Only one thread can execute at a time.
           LOCK is a reference to an object
           whose lock associates with the monitor.
           The code is said to be synchronized on
           the monitor object.


       -->This synchronization is implemented in Java with a concept called monitors or locks.
          Only one thread can own a monitor at a given time.
          When a thread acquires a lock, it is said to have entered the monitor.
          All other threads attempting to enter the locked monitor will be suspended
          until the first thread exits the monitor.

     */
    public void generate() throws InterruptedException{
        synchronized (LOCK){            //--> use keyword synchronized(Object name)
            for (int i = 0; i <=20 ; i++) {
                if(i<=10){
                    System.out.print("[");
                }else{
                    System.out.print("]");
                }
            }

            System.out.println();
        }
        for (int i = 0; i < 10 ; i++) {
            Thread.sleep(10);
        }




    }
}



