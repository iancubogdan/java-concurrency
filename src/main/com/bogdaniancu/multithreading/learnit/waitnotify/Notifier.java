package main.com.bogdaniancu.multithreading.learnit.waitnotify;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Notifier implements Runnable{
    private Message message;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        try {
            Thread.sleep(100);
            synchronized (message) {
                message.setMessage(name + " Notifier work done");
//                message.notify();
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Notifier finished work");
    }
}
