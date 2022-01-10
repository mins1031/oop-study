package com.example.oopbasic.encapsulation.example1.member;

import com.example.oopbasic.Account;
import com.example.oopbasic.encapsulation.AuthResult;
import com.example.oopbasic.encapsulation.example1.member.MemberShip;
import com.example.oopbasic.encapsulation.example1.member.domain.Member;
import com.example.oopbasic.encapsulation.example1.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EncapsulationExample {

    MemberRepository memberRepository = new MemberRepository();
    private final PasswordEncoder passwordEncoder;

    public void nonEncapsulation(Account account) {
        if (account.getMemberShip() == MemberShip.REGULAR && account.getExpDate().isAfter(LocalDate.now())) {
            //1차 정회원 기능 내용
        }

        //위의 1차 정회원 기능에 대한 내용이 밑의 내용으로 바뀌게됨
        // 5년이상 사용자에게 일부 기능 정회원 혜택 1달 무상 제공하는 기능이 구현되었다.
        if (account.getMemberShip() == MemberShip.REGULAR &&
                (/*account.getServiceDate().isAfter(fiveYearAgo) && */ account.getExpDate().isAfter(LocalDate.now())) /* ||
            (account.getServiceDate().isBefore(fiveYearAgo) && addMonth(account.getExpDate().isAfter(LocalDate.now()))
                        )*/
        ) {
            //추가 정회원 기능 내용
        }
        /**
         * 다소 복잡하지만 해당 조건문처럼 기능이 생기고 구조가 크다면 위의 코드가 여러군데 산재해 있을 가능성이 높다...
         * 위의 인증 내용은 Account의 데이터를 사용해 인증하는 로직이기 때문에 위의 내용을 Account로 집어 넣고 해당 서비스로직은 Account의 메서드를 호출하는 방식으로 구현하면 연쇄 코드 수정을 최소화 할 수 있다.
         * */
    }

    public AuthResult authenticate(String id, String pw) {
        Member member = memberRepository.findOne(id);

        if (member == null) {
            return AuthResult.NO_MATCH;
        }

        if (member.isEmailStatusVerified(2)) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (member.isPasswordValid(passwordEncoder, pw)) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
    }
}
