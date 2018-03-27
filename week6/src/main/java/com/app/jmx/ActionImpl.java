package com.app.jmx;


public class ActionImpl implements ActionMBean {

    @Override
    public void action(String action) {
        System.out.println("Performed following action: " + action);
    }
}