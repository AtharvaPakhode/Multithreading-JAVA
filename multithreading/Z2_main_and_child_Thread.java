package multithreading;
import java.io.*;
import java.util.*;
public class Z2_main_and_child_Thread {
    // just for file name
}




// Java program to control the Main Thread

class Test extends Thread {

    // Main driver method
    public static void main(String[] args)
    {

        // Getting reference to Main thread by calling currentThread() method
        Thread t = Thread.currentThread(); // t is reference for current thread  i.e. main thread

        // Getting name of Main thread
        System.out.println("Current thread: " + t.getName()); //it prints --> main

        // Changing the name of Main thread
        t.setName("new_name");
        System.out.println("After name change: " + t.getName());

        // Getting priority of Main thread i.e. default priority 5
        System.out.println("Main thread priority: " + t.getPriority());

        // Setting priority of Main thread to MAX(10)
        t.setPriority(MAX_PRIORITY);

        // Print and display the main thread priority
        System.out.println("Main thread new priority: " + t.getPriority());


        System.out.println("Main thread called");


        // Main thread creating a child thread
        ChildThread ct = new ChildThread();

        // Getting priority of child thread
        // which will be inherited from Main thread
        // as it is created by Main thread
        System.out.println("Child thread priority: " + ct.getPriority());

        // Setting priority of child thread to MIN(1)
        ct.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Child thread new priority: " + ct.getPriority());

        // Starting child thread
        ct.start();
    }
}

// Class 2
// Helper class extending Thread class
// Child Thread class
class ChildThread extends Thread {

    @Override
    public void run()
    {

            System.out.println("Child thread called ");

    }
}

