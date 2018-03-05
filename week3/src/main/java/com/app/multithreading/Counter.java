package com.app.multithreading;

import com.app.App;

public class Counter {
    private int count = 0;

    public synchronized void add(int value) {
        for (int i = 0; i < value; i++)
            count += i;
        System.out.println("Sum:" + count);

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
