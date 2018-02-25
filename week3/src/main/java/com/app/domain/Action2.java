package com.app.domain;

public interface Action2 {
    default void action() {
        System.out.println("Action from default method of interface Action2");
    }
}
