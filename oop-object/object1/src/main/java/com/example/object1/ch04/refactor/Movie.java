package com.example.object1.ch04.refactor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNonDiscountedFee() {
        if (movieType != MovieType.NON_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return Money.ZERO;
    }

    public boolean isDiscountTable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
                if (discountCondition.isDiscountTable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (discountCondition.isDiscountTable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }

    public MovieType getMovieType() {
        return movieType;
    }

}
