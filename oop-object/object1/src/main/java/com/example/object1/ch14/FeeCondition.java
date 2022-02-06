package com.example.object1.ch14;

import com.example.object1.ch10.part3.step2.Call;

import java.util.List;

public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
