package main.com.bogdaniancu.multithreading.learnit.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadFactoryDemo {

    public static void main(String[] args) {
        int threadNum = 4;
        var es = Executors.newFixedThreadPool(threadNum, new DefaultThreadFactory());

//        IntStream.range(0, threadNum).forEach(i -> {
//            es.submit(() -> System.out.println(Thread.currentThread().getName()));
//        });


        IntStream.range(0, threadNum).forEach(i -> {
            Future<Integer> submit = es.submit(() ->{
                System.out.println(Thread.currentThread().getName());
                return i;
            });
            try {
                System.out.println("Result: " + submit.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });



        es.shutdown();
    }
}

class DefaultThreadFactory implements ThreadFactory {

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Custom Thread Factory | Thread #" + counter.getAndIncrement());
    }
}
