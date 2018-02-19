package com.app;

import com.app.model.Person;
import com.app.utils.Utils;
import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;


public class AppTest {
    private List<Person> personList;

    private Consumer<Person> print = person -> {
        System.out.println(person.getFirstName());
        System.out.println(person.getPhone());
    };

    @Before
    public void intit() {
        personList = Lists.newArrayList(
                new Person("Mark", "Markovich", Lists.newArrayList("28264", "0993343698")),
                new Person("Robert", "baratheon", Lists.newArrayList("12345", "34536356")),
                new Person("Andrew", "Stark", Lists.newArrayList("123123", "2352235")),
                new Person("Michael", "Rodriguez", Lists.newArrayList("12344", "3564754")));
    }

    @Test
    public void firtsNamesFilterTest() {


        Optional<Person> mike = personList.stream()
                .filter(person -> person.getFirstName().startsWith("Mic") || person.getFirstName().startsWith("And"))
                .sorted(Comparator.comparing(Person::getLastName)).limit(1).peek(print)
                .findFirst();

        assertEquals("Michael", mike.get().getFirstName());
        assertEquals(Lists.newArrayList("12344", "3564754"), mike.get().getPhone());
    }

    @Test
    public void streamCreationTest() {
        Stream<Person> stream = Stream.of(new Person("Mark", "Markovich", Lists.newArrayList("28264", "0993343698")),
                new Person("Robert", "baratheon", Lists.newArrayList("12345", "34536356")),
                new Person("Andrew", "Stark", Lists.newArrayList("123123", "2352235")),
                new Person("Michael", "Rodriguez", Lists.newArrayList("12344", "3564754")));

        List<Person> persons = stream
                .filter(person -> person.getFirstName().startsWith("Mic") || person.getFirstName().startsWith("And"))
                .sorted(Comparator.comparing(Person::getLastName))
                .limit(1)
                .collect(Collectors.toList());

        assertEquals(persons.size(), 1);
    }

    @Test
    public void showPhonesTest() {
        HashSet<String> phones = personList.stream().limit(1).collect(Utils.personPhonesCollector());
        System.out.println(phones);
        assertEquals(phones.size(), 2);
    }


}
