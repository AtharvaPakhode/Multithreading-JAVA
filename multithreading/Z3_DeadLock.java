package multithreading;

public class Z3_DeadLock {
    public static void main(String[] args) {

        final String resource1 = "a";
        final String resource2 = "b";

        Thread t1 = new Thread() {
            public void run() {


                synchronized (resource1) {
                    System.out.println("thread1 locked resource1");
                    try { Thread.sleep(10000);} catch (Exception e) {}   // after 10 seconds of sleep t1 will realease lock

                }




                synchronized (resource2) {
                    System.out.println("thread1 locked resource2");
                }


            }
        };

        Thread t2 = new Thread() {
            public void run() {

                synchronized (resource2) {
                    System.out.println("thread2 locked resource2");

                }

                try { Thread.sleep(8000);} catch (Exception e) {}


                synchronized (resource1) {
                    System.out.println("thread2 locked resource1");
                }


            }


        };


        t1.start();
        t2.start();

    }



}

/*

thread1 locked resource1
thread2 locked resource2     for first 10 seconds output will be this

after t1 releases the lock , it will lock resource 2 which is already release by t2
and the t2 will lock resource 1

thread1 locked resource2
thread2 locked resource1    

 */

