package com.app.synchronizer.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable barrier1Action = () -> System.out.println("Barrier 1 executed");
        Runnable barrier2Action = () -> System.out.println("Barrier 2 executed");

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        CyclicBarrierRunnable barrierRunnable2 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}
