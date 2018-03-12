package com.app.synchronizer.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private CountDownLatch latch = null;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Task started");
        try {
            TimeUnit.SECONDS.sleep(1);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 1 finished");
    }
}
