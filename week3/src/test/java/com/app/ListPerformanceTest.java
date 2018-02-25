package com.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class ListPerformanceTest {
    private int size;
    private long startTime;
    private long estimatedTime;
    private Integer[] arrayOfInts;

    @Before
    public void init() {
        size = 100_000;

        arrayOfInts = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrayOfInts[i] = new Random().nextInt(10);
        }

    }

    @Test
    public void addInBeginTest() {
        System.out.println("List: add elements in begin");
        System.out.println("Array list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.addInBegin(new ArrayList<>(), size);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);
        System.out.println();

        System.out.println("Linked list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.addInBegin(new ArrayList<>(), size);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);

        Assert.assertTrue(true);
    }

    @Test
    public void addInEndTest() {
        System.out.println("List: add elements in end");
        System.out.println("Array list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.addInEnd(new ArrayList<>(), size);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);
        System.out.println();

        System.out.println("Linked list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.addInEnd(new ArrayList<>(), size);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);

        Assert.assertTrue(true);
    }

    @Test
    public void loopAllElementsTest() {

        List<Integer> testLinkedList = new LinkedList<>(Arrays.asList(arrayOfInts));
        List<Integer> testArrayList = new ArrayList<>(Arrays.asList(arrayOfInts));


        System.out.println("List: loop all elements");
        System.out.println("Array list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.loopAllElements(testArrayList);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);
        System.out.println();

        System.out.println("Linked list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.loopAllElements(testLinkedList);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);

        Assert.assertTrue(true);
    }

    @Test
    public void randomAccessTest() {
        List<Integer> testLinkedList = new LinkedList<>(Arrays.asList(arrayOfInts));
        List<Integer> testArrayList = new ArrayList<>(Arrays.asList(arrayOfInts));

        System.out.println("List: random access");
        System.out.println("Array list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.randomAccess(testArrayList);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);
        System.out.println();

        System.out.println("Linked list: ");
        startTime = System.currentTimeMillis();

        ListPerformance.randomAccess(testLinkedList);

        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.format("Time of execution: %d ms", estimatedTime);

        Assert.assertTrue(true);
    }


}