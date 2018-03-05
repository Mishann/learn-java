package com.app.domain;

import com.app.domain.annotation.ClassInfo;
import com.app.domain.annotation.Date;
import com.app.domain.annotation.Primary;

@ClassInfo(version = 1, author = "Michael Shnitser", date = @Date(day = 26, month = 2, year = 2018))
public class Person {

    private String firstName;
    private String lastName;

    @Primary
    private String[] phones;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}
