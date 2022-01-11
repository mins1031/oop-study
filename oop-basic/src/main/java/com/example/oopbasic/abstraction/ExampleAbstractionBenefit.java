package com.example.oopbasic.abstraction;

public class ExampleAbstractionBenefit {
    //1차코드 주문 취소 로직에 SmsSender만 있는경우
    /*private SmsSender smsSender;

    public void cancel(String ono) {
        //.. 주문 취소 처리 로직

        smsSender.sendSms();
    }*/

    //2차코드 - 요구사항이 늘어날수록 코드가 난잡해 진다.
    /*private SmsSender smsSender;
    private KakaoPush kakaoPush;

    public void cancel(String ono) {
        //.. 주문 취소 처리 로직

        boolean pushEnabled = true;
        if (pushEnabled) {
            kakaoPush.push();
        } else {
            smsSender.sendSms();
        }
    }*/

    //3차 코드 - 주문 취소가 처리되면 메일도 무조건 발송해야 하는 로직 추가
    /*private SmsSender smsSender;
    private KakaoPush kakaoPush;
    private MailService mailService;

    public void cancel(String ono) {
        //.. 주문 취소 처리 로직

        boolean pushEnabled = true;
        if (pushEnabled) {
            kakaoPush.push();
        } else {
            smsSender.sendSms();
        }
        mailService.sendMail();
    }*/


}
