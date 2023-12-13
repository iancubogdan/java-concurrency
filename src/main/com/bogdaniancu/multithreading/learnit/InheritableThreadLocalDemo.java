package main.com.bogdaniancu.multithreading.learnit;

public class InheritableThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("******Thread #1******");
            threadLocal.set("____Thread #1 - ThreadLocal_____");
            inheritableThreadLocal.set("_____Thread #1 - InheritableThreadLocal______");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("******ChildThread******");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });
        thread1.start();

        Thread thread2 = new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("******Thread2******");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });
        thread2.start();
    }

}
