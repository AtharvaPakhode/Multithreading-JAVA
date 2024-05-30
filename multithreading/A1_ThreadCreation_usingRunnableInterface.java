package multithreading;

public class A1_ThreadCreation_usingRunnableInterface {
    public static void main(String[] args)
    {

        // Creating object of our thread class inside main()
        // method
        NewThread obj = new NewThread();

        // Passing the object to thread in main()
        Thread myThread = new Thread(obj);

        // Starting the thread
        myThread.start();
    }
}


// Creating thread using Runnable interface

class NewThread implements Runnable {

    // Method 1
    // run() method for the thread
    public void run()
    {

        // Print statement
        System.out.println("Thread is running");
    }



}

