package com.example.object1.step2;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTicket(audience);
    }

    /**
     * step2에선 책 내용대로 의존성을 줄이는 작업을 진행.
     * */
}
