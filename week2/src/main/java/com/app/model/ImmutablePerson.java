package com.app.model;

import java.util.HashSet;
import java.util.Iterator;

public final class ImmutablePerson {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final HashSet<String> address;

    /*
     * Applies deep copy
     * */
    public ImmutablePerson(String firstName, String lastName, Integer age, HashSet<String> address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.address = address;

        Iterator<String> iterator = address.iterator();
        while (iterator.hasNext())
            this.address.add(iterator.next());

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public HashSet<String> getAddress() {
        return (HashSet<String>) address.clone();
    }
}
