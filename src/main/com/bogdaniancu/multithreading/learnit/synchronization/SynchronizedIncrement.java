package main.com.bogdaniancu.multithreading.learnit.synchronization;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedIncrement {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(SynchronizedIncrement::increment);
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);

    }

    public synchronized static void increment() {
        counter++;
    }

    public static void incrementWithSyncBlock() {
        synchronized (SynchronizedIncrement.class) {
            counter++;
        }
    }
}
