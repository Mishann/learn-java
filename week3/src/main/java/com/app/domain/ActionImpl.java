package com.app.domain;

public class ActionImpl implements Action1, Action2 {
    @Override
    public void action() {
        Action1.super.action();
    }

}
