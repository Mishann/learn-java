package com.app.synchronizer.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatcherExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Task task = new Task(latch);
        Decrementer decrementer = new Decrementer(latch);

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        thread2.start();

    }
}
