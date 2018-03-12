package com.app.executors;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;

public class ExecutorsExample {

    private static BiFunction<String, Integer, String> simulateAction = (name, time) -> {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
        }
        return name;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fixedThreadPool();
        scheduledThreadPool();
    }

    public static void fixedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> thead1 = () -> {

            return simulateAction.apply("thread1", 2);
        };

        Callable<String> thead2 = () -> simulateAction.apply("thread2", 2);
        Callable<String> thead3 = () -> simulateAction.apply("thread3", 2);

        System.out.println(executorService.submit(thead1).get());
        System.out.println(executorService.submit(thead2).get());
        System.out.println(executorService.submit(thead3).get());


        List<Callable<String>> tasks = Lists.newArrayList(thead1, thead2, thead3);
        List<Future<String>> results = executorService.invokeAll(tasks);

        for (Future<String> future : results)
            System.out.println(future.get());

        executorService.shutdown();
    }

    public static void scheduledThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Runnable thread1 = () -> System.out.println(simulateAction.apply("thread1", 2));
        //with delay
        executorService.schedule(thread1, 2, TimeUnit.SECONDS);
        //with period
        executorService.scheduleAtFixedRate(thread1, 1, 5, TimeUnit.SECONDS);


    }

}
