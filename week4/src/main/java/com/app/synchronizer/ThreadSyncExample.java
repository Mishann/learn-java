package com.app.synchronizer;

import java.util.concurrent.TimeUnit;

public class ThreadSyncExample {
    public static class Task {
        private final Object object = new Object();

        public void unSyncMethod() throws InterruptedException {
            System.out.println("unsynchronized method started");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("unsynchronized method end");
        }

        public synchronized void syncMethod() throws InterruptedException {
            System.out.println("sync method started ");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("sync method end");
        }

        public void withCriticalSectionMethod() throws InterruptedException {
            synchronized (object) {
                System.out.println("with critical section method started");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("with critical section method ended");
            }
        }
    }

    private static class TaskThread extends Thread {
        private Task task;

        public TaskThread(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " is running");
            try {
                task.unSyncMethod();
                task.syncMethod();
                task.withCriticalSectionMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " has ended");
        }
    }

    public static void main(String[] args) {
        Task task = new ThreadSyncExample.Task();
        for (int i = 0; i < 10; i++) {
            new TaskThread(task).start();
        }
    }

}
