package com.app.utils;

import com.app.model.Person;

import java.util.HashSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Utils {

    public static Collector<Person, HashSet<String>, HashSet<String>> personPhonesCollector() {
        Supplier<HashSet<String>> supplier = () -> new HashSet<>();
        BiConsumer<HashSet<String>, Person> accumulator = (acc, person) -> acc.addAll(person.getPhone());
        BinaryOperator<HashSet<String>> combiner = (set1, set2) -> {
            set2.forEach(set1::add);
            return set1;
        };
        return Collector.of(supplier, accumulator, combiner);
    }


}
