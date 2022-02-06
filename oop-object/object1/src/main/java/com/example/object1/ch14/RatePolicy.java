package com.example.object1.ch14;

import com.example.object1.ch10.part3.step2.Phone;

public interface RatePolicy {
    public Money calculateFee(Phone phone);
}
