package main.com.bogdaniancu.multithreading.learnit.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                () -> {
                    Thread.sleep(500);
                    return "task1";
                },
                () -> {
                    Thread.sleep(200);
                    return "task2";
                },
                () -> {
                    Thread.sleep(300);
                    return "task3";
                }
        ));

        String result = es.invokeAny(tasks);
        System.out.println(result);
    }
}
