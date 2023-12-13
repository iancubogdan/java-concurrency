package main.com.bogdaniancu.multithreading.learnit.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteWithExecutorServicesDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));

    }
}
