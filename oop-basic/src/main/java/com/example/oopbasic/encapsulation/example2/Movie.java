package com.example.oopbasic.encapsulation.example2;

import lombok.Getter;

@Getter
public class Movie {
    public static int REGULAR = 0;
    public static int NEW_RELEASE = 1;
    private int priceCode;

    public int verifyRenterPoints(int daysRented) {
        if (this.priceCode == NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
