package com.app;

import com.app.domain.Action1;
import com.app.domain.Action2;
import com.app.domain.ActionImpl;
import com.app.domain.Person;
import com.app.domain.annotation.ClassInfo;
import com.app.domain.annotation.Primary;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IllegalAccessException {
/*
flatMapExample();
interfacesWithSameMethodsExample();
*/
        annotationExample();

    }

    private static void flatMapExample() {
        List<List<Integer>> containerList = new ArrayList<>();

        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(4, 5, 6);

        containerList.add(list1);
        containerList.add(list2);

        containerList.stream().flatMap(List::stream).forEach(System.out::println);
    }

    private static void interfacesWithSameMethodsExample() {
        Action1 action1 = new ActionImpl();
        action1.action();
    }

    private static void annotationExample() throws IllegalAccessException {
        Person p = new Person();
        p.setFirstName("Anna");
        p.setLastName("Kane");
        p.setPhones(new String[]{"123", "456"});

        // read info about class object
        Class<?> pClazz = p.getClass();

        if (pClazz.isAnnotationPresent(ClassInfo.class)) {
            ClassInfo info = pClazz.getAnnotation(ClassInfo.class);
            System.out.println(info.version());
            System.out.println(info.author());
            String date = info.date().day() + ":" + info.date().month() + ":" + info.date().year();
            System.out.println(date);
        }
        for (Field field : pClazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Primary.class)) {
                Primary primary = field.getAnnotation(Primary.class);
                int actual = primary.actual() - 1;
                String[] phones = (String[]) field.get(p);
                String actualPhoneNumber = phones[actual];
                System.out.println(actualPhoneNumber);
            }

        }


    }

}














