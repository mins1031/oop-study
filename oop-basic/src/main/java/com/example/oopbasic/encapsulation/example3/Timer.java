package com.example.oopbasic.encapsulation.example3;

import lombok.Getter;

@Getter
public class Timer {

    public long startTime;
    public long stopTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public long calculateTime() {
        return stopTime - startTime;
    }
}
