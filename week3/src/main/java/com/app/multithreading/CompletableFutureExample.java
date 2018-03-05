package com.app.multithreading;

import com.app.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completebleFutureExample();
        futureExample();
        while (true)
            ;
    }

    private static void completebleFutureExample() throws InterruptedException {
        CompletableFuture<List<String>> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting completebleFuture...");
            return getPersonList();
        }).thenApplyAsync(people -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            people.stream().forEach(CompletableFutureExample::updateAge);
            return people;
        }).thenCompose(people -> CompletableFuture.supplyAsync(() -> getPhoneList(people)))
                .whenComplete((phones, throwable) -> {
                    System.out.println("From completable future: "+phones);
                    System.out.println("Finished completebleFuture");

                });
    }


    private static void futureExample() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<String>> future = executor.submit(() -> {
            System.out.println("Starting future...");
            List<User> persons = getPersonList();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            persons.stream().forEach(CompletableFutureExample::updateAge);
            List<String> phoneList = getPhoneList(persons);
            return phoneList;
        });
        System.out.println("From future: "+future.get() );
        System.out.println("Finished future...");
    }


    private static List<User> getPersonList() {
        List<User> personList = new ArrayList<>();

        User p1 = new User("Michael", 22, new String[]{"123", "456"});
        User p2 = new User("Rick", 23, new String[]{"000", "0001"});
        User p3 = new User("Anna", 24, new String[]{"3333", "3331"});

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        return personList;
    }

    private static User updateAge(User person) {
        person.setAge(person.getAge() + 1);
        return person;
    }

    private static List<String> getPhoneList(List<User> persons) {
        return persons.stream().map(x -> Arrays.asList(x.getPhones())).flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
