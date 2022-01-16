package com.example.object1.ch02;

public class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(double percent) {
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(this.percent);
    }
}
