package com.example.oopbasic.encapsulation.example4;

import com.example.oopbasic.encapsulation.example1.member.domain.Member;
import com.example.oopbasic.encapsulation.example4.exception.AlreadyVerifiedException;

public class Example4Code {

    public void verifyEmail(String token) {
        Member member = findByToken(token);
        //기존코드
        if (member == null) {
            throw new NullPointerException();
            //해당 조건은 보나 마나한 코드이지만... 일단....
        }

        //데이터를 가져와서 판단한 다음 다시 그 데이터를 바꾸는 유형의 코드는 코드 전체를 캡슐화하면 더 좋은 결과를 얻을 가능성이 높다.
        if (member.isEmailStatusVerified()) {
            throw new AlreadyVerifiedException();
        } else {
            member.setEmailStatus(2);
        }

        //개선 코드
        if (member == null) {
            throw new NullPointerException();
        }


    }

    private Member findByToken(String token) {
        return new Member("id");
    }
}
