package main.com.bogdaniancu.multithreading.learnit.synchronization;

import java.util.ArrayList;
import java.util.List;

public class NonSynchronizedIncrement {

    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(NonSynchronizedIncrement::increment);
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);

    }

    public static void increment() {
        counter++;
    }
}
