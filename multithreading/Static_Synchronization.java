package multithreading;

public class Static_Synchronization {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {

                    try {
                        Brackets2.generate();
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
                        Brackets2.generate();
                        /*
                                --> generate() is static method
                                    ,so we can use it using class name
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
class Brackets2{

    synchronized public static void generate() throws InterruptedException{

            for (int i = 0; i <=20 ; i++) {
                if(i<=10){
                    System.out.print("[");
                }else{
                    System.out.print("]");
                }
            }

            System.out.println();

        for (int i = 0; i < 10 ; i++) {
            Thread.sleep(10);
        }

    }
}
