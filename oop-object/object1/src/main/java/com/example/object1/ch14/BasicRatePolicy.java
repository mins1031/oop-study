package com.example.object1.ch14;

import com.example.object1.ch10.part3.step2.Call;
import com.example.object1.ch10.part3.step2.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicRatePolicy implements RatePolicy{
    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(FeeRule ...feeRules) {
        this.feeRules = Arrays.asList(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                .stream()
                .map(call -> calculate(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }


    private Money calculate(Call call) {
        return feeRules.stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
