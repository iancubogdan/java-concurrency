package main.com.bogdaniancu.multithreading.learnit.waitnotify;

public class Demo  {

    public static void main(String[] args) {
        Message message = new Message("process it");

        Reader reader1 = new Reader(message);
        new Thread(reader1, "Reader 1").start();

        Reader reader2 = new Reader(message);
        new Thread(reader2, "Reader 2").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "Notifier").start();
        System.out.println("All the threads are started");

    }
}
