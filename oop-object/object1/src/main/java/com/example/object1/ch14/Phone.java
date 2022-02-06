package com.example.object1.ch14;

import com.example.object1.ch10.part3.step3.Call;
import com.example.object1.ch10.part3.step3.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<com.example.object1.ch10.part3.step3.Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public com.example.object1.ch10.part3.step3.Money calculateFee() {
        com.example.object1.ch10.part3.step3.Money result = com.example.object1.ch10.part3.step3.Money.ZERO;

        for (com.example.object1.ch10.part3.step3.Call call : calls) {
            result = calculateCallFee(call);
        }

        return result.plus(result.times(taxRate));
    }

    abstract protected Money calculateCallFee(Call call);
}
