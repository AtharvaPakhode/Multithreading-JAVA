package multithreading;

public class Synchronization1 {
    public static int counter=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread (new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <= 100000; i++) {
                    Synchronization1.counter++; //--> becoz counter variable is static
                }
                System.out.println("the loop1 over");
            }
        }).start();

        new Thread (new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <= 100000; i++) {
                    Synchronization1.counter++; //--> becoz counter variable is static
                }
                System.out.println("the loop2 over");
            }
        }).start();


        System.out.println(counter);
    }
}
/*

OUTPUT:                                 Expected OUTPUT:
37450/any random no(1-200000)           the loop1 over
the loop1 over                          the loop2 over
the loop2 over                          200000

--> when multiple threads are using single outer variable this inconsistency is due to hardware itself.
--> we can resolve it by synchronization
 */