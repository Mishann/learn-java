package com.app;

import com.app.model.ImmutablePerson;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        immutableExample();
    }
    private static void immutableExample() {
        HashSet<String> address = new HashSet<>();
        address.add("Lviv");

        ImmutablePerson person1 = new ImmutablePerson("John", "Doe", 22, address);

        System.out.println("Is equal objects");
        System.out.println(address == person1.getAddress());
    }

}
