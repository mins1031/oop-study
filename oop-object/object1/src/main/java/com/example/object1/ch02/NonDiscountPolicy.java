package com.example.object1.ch02;

public class NonDiscountPolicy extends DiscountPolicy{
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
