package com.example.object1.ch04;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountTable = false;
        for (DiscountCondition discountCondition : movie.getDiscountConditions()) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
                discountTable = screening.getWhenScreened().getDayOfWeek().equals(discountCondition.getDayOfWeek()) &&
                        discountCondition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        discountCondition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountTable = discountCondition.getSequence() == screening.getSequence();
            }

            if (discountTable) {
                break;
            }
        }

        Money fee;
        if (discountTable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NON_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
