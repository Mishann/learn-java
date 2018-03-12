package com.app.executors;

public class DeadLockExample {
    private static String lock1 = "lock1";
    private static String lock2 = "lock2";

    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        Runnable task1 = () -> {
            while (true) {
                synchronized (lock1) {
                    System.out.println("Thread1 holds lock1");
                    synchronized (lock2) {
                        System.out.println("Thread1 holds lock2");
                    }
                }
            }
        };

        Runnable task2 = () -> {
            while (true) {
                synchronized (lock2) {
                    System.out.println("Thread2 holds lock1");
                    synchronized (lock1) {
                        System.out.println("Thread2 holds lock2");
                    }
                }
            }
        };
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
