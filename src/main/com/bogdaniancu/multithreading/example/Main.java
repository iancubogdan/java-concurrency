package main.com.bogdaniancu.multithreading.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //Code that will run in a new thread
            System.out.println("We are now in thread: " + Thread.currentThread().getName());
            System.out.println("Current Thread Priority is " + Thread.currentThread().getPriority());
            throw  new RuntimeException("Intentional Exception");
        });
        t.setName("New Worker Thread");
        t.setPriority(Thread.MAX_PRIORITY);
        t.setUncaughtExceptionHandler((t1, e) -> System.out.println("A critical error happened in thread " + t1.getName()
            + " the error is " + e.getMessage()));

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        t.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

//        Thread.sleep(10000);
    }
}
