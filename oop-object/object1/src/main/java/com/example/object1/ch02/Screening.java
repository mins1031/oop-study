package com.example.object1.ch02;

import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenSreeened;

    public Screening(Movie movie, int sequence, LocalDateTime whenSreeened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenSreeened = whenSreeened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        //원래는 movie의 calculateMovieFee를 호출한다고 했지만 사실은 screening이 movie에게 calculateMovieFee 메세지를 전송한다. 라고 말하는 것이 더 적절한 표현이다.
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getStartTime() {
        return whenSreeened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
