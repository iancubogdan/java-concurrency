package main.com.bogdaniancu.multithreading.learnit.waitnotify;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Reader implements Runnable{

    private Message message;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (message) {
            try {
                System.out.println(name + " waiting to get notified at time:  " + System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " waiting thread got notified at time: " + System.currentTimeMillis());
            System.out.println(name + " processed: " + message.getMessage());
        }

    }
}
