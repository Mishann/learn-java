package com.app.domain;

public class User {
    private String name;
    private Integer age;
    private String[] phones;

    public User(String name, Integer age, String[] phones) {
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}
