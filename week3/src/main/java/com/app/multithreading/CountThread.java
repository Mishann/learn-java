package com.app.multithreading;

import com.app.App;

public class CountThread extends Thread {
    private Counter counter = null;

    public CountThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.add(1000);
    }
}
