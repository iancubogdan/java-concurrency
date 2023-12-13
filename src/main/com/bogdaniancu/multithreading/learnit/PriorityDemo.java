package main.com.bogdaniancu.multithreading.learnit;

public class PriorityDemo {

    public static void main(String[] args) {
        Thread t0 = new Thread(PriorityDemo::execute);
        Thread t1 = new Thread(PriorityDemo::execute);
        Thread t2 = new Thread(PriorityDemo::execute);
        Thread t3 = new Thread(PriorityDemo::execute);
        Thread t4 = new Thread(PriorityDemo::execute);
        Thread t5 = new Thread(PriorityDemo::execute);

        t0.setPriority(1);
        t1.setPriority(10);
        t2.setPriority(10);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(4);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void execute() {
        System.out.println(Thread.currentThread().getName());
    }
}
