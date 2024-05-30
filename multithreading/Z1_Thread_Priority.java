package multithreading;
// Importing required classes
import java.lang.*;
public class Z1_Thread_Priority  {
    // class defined for file name
}
class ThreadDemo extends Thread{
    public void run() {
        System.out.println("Inside run method");
    }

    // Main driver method
    public static void main(String[] args) {
        // Creating random threads
        // with the help of above class
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();


        System.out.println("t1 thread priority : " + t1.getPriority());  //t1 thread priority : 5
        System.out.println("t2 thread priority : " + t2.getPriority());  //t2 thread priority : 5
        System.out.println("t3 thread priority : " + t3.getPriority());  //t3 thread priority : 5

        // Setting priorities of above threads by
        // passing integer arguments
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);


        System.out.println("t1 thread priority : " + t1.getPriority());  //2
        System.out.println("t2 thread priority : " + t2.getPriority());  //5
        System.out.println("t3 thread priority : " + t3.getPriority());  //8


        // Main thread
        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName()); //main

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());   //5

        Thread.currentThread().setPriority(10);

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());   //10
    }
}

