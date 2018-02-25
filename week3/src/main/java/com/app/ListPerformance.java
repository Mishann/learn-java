package com.app;

import java.util.*;

public class ListPerformance {

    public static <T extends List<Integer>> void addInBegin(T list, int size) {
        for (int i = 0; i < size; i++)
            list.add(0, new Random().nextInt(10));
    }

    public static <T extends List<Integer>> void addInEnd(T list, int size) {
        for (int i = 0; i < size; i++)
            list.add(new Random().nextInt(10));
    }


    public static <T extends List<Integer>> void loopAllElements(T list) {
        for (int i = 0; i < list.size(); i++) {
            Integer res = list.get(i);
        }
    }

    public static <T extends List<Integer>> void randomAccess(T list) {
        for (int i = 0; i < list.size(); i++) {
            Integer res = list.get(new Random().nextInt(list.size() - 1));
        }
    }


}
