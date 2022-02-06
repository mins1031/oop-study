package com.example.object1.ch14;

import com.example.object1.ch10.part3.step2.Call;

import java.time.LocalTime;
import java.util.List;

public class TimeOfDayFeeCondition implements FeeCondition{
    private LocalTime from;
    private LocalTime of;

    public TimeOfDayFeeCondition(LocalTime from, LocalTime of) {
        this.from = from;
        this.of = of;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return null;
    }
}
