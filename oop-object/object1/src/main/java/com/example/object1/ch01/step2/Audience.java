package com.example.object1.ch01.step2;

//관람객
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buyTicket(Ticket ticket) {
        return bag.hold(ticket);
    }
}
