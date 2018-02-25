package com.app;

import com.app.domain.Action1;
import com.app.domain.Action2;
import com.app.domain.ActionImpl;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //flatMapExample();
        interfacesWithSameMethodsExample();
    }

    private static void flatMapExample() {
        List<List<Integer>> containerList = new ArrayList<>();

        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(4, 5, 6);

        containerList.add(list1);
        containerList.add(list2);

        containerList.stream().flatMap(List::stream).forEach(System.out::println);
    }

    private static void interfacesWithSameMethodsExample(){
        Action1 action1 = new ActionImpl();
        action1.action();
    }


}
