package com.example.object1.ch01.step1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            //초대받은 손님이기 떄문에 Invitation을 확인후 티켓을 받게 됨.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            //초대 받지 않은 손님이기 때문에 티켓에 대한 값을 치름.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

    /**
     * 1. enter가 너무 많은 내용을 가지고 있음. =  의존이 너무 많이 되어있음
     * 2. enter의 역할이 너무 많음. -> 초대 확인, 티켓가방에 넣어주기, 티켓구매소의 금액 증강등,,
     * 3. 유연하지 않음.
     * */
}
