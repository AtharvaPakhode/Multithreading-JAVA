package multithreading;

public class Synchronization2 {
    public static void main(String[] args) {
        Brackets b = new Brackets();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    b.generate();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    b.generate();
                }
            }
        }).start();
    }
}
class Brackets{
    synchronized public void generate(){   //--> use keyword synchronized
        for (int i = 0; i <=20 ; i++) {
            if(i<=10){
                System.out.print("[");
            }else{
                System.out.print("]");
            }
        }
        System.out.println();
    }
}

/*
OUTPUT WITHOUT SYNC:

[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[][[[[[[[[]]]]]]]]]
[[[[[[[[[[[]]]]]][[[]]]]]]]]]]
[[[[]]]]
[[[[[[[[[[[[[]][[[[[]]]]]]]]]]]]]
]]]]]
[[[[[[[[[[[[[[[[[[[][[[]]]]]]]]]]]]]]]]]]
[[]
[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]


OUTPUT WITH SYNC:

[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
[[[[[[[[[[[]]]]]]]]]]
 */

