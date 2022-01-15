package com.example.object1.ch01.step2;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public void sellTicket(Audience audience) {
        ticketOffice.plusAmount(audience.buyTicket(ticketOffice.getTicket()));
    }
}
