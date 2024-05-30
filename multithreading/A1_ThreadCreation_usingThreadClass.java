package multithreading;

public class A1_ThreadCreation_usingThreadClass {


    public static void main(String[] args)
    {

        // Creating object of our thread class inside main()
        // method
        MyThread myThread = new MyThread();


        myThread.start(); //starts a new thread, which then calls run method  on the new thread.

    }
}




// Creating thread By Extending To Thread class

class MyThread extends Thread {

    @Override
    public void run()
    {
        // Print statement
        System.out.println("thread is running");

        /*/

        the print statement is executed because
        the start method internally calls the run method on a new thread,
        resulting in "thread is running" being printed to the console.

         */
    }

}

