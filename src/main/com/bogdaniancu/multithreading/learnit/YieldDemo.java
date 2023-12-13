package main.com.bogdaniancu.multithreading.learnit;

public class YieldDemo {

    public static void main(String[] args) {
        Thread t0 = new Thread(() -> {
            Thread.yield();
            System.out.println(Thread.currentThread().getName());
        });

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t0.start();
        t1.start();
    }
}
