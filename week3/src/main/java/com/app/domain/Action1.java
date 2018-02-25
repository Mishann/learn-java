package com.app.domain;

public interface Action1 {
    default void action() {
        System.out.println("Action from default method of interface Action1");
    }

}
