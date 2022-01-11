package com.example.oopbasic.encapsulation.example3;

public class Example3Code {

    public void isTimerExample() {
        //기존코드
        Timer t = new Timer();
        t.startTime = System.currentTimeMillis();

        t.stopTime = System.currentTimeMillis();
        long surveyTime = t.stopTime - t.startTime;

        //개선 코드
        t.start();

        t.stop();

        long resultTimer = t.calculateTime();
    }
}
