package main.com.bogdaniancu.multithreading.learnit;

public class ThreadLocalDemo implements Runnable {

//    private static ThreadLocal<String> transactionId = ThreadLocal.withInitial(() -> "n/a");
    private static ThreadLocal<Integer> transactionId = new ThreadLocal<>();


    public static void main(String[] args) {
        ThreadLocalDemo runnable = new ThreadLocalDemo();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        transactionId.set((int)( Math.random() *100));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(transactionId.get());
    }
}
