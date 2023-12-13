package main.com.bogdaniancu.multithreading.learnit.callable;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> future = es.submit(() -> 1 + 1);

        System.out.println("Getting result: " + future.get(10, TimeUnit.SECONDS));
        es.shutdown();
    }
}
