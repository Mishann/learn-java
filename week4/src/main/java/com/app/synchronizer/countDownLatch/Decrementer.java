package com.app.synchronizer.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {
    private CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (; ; ) {
            if (latch.getCount() != 0) {
                System.out.println("count down");
                latch.countDown();
            } else
                break;
        }
    }
}
