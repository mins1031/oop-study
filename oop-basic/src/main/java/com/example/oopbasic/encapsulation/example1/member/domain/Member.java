package com.example.oopbasic.encapsulation.example1.member.domain;

import com.example.oopbasic.encapsulation.example4.exception.AlreadyVerifiedException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    private String id;
    private String name;
    private String pw;
    private int emailStatus;

    public Member(String id) {
        this.id = id;
    }

    public boolean isEmailStatusVerified() {
        return this.emailStatus == 2;
    }

    public boolean isPasswordValid(PasswordEncoder passwordEncoder, String inputPw) {
//        passwordEncoder.
        return true;
    }

    public void setEmailStatus(int emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void verifyEmail() {
        if (isEmailStatusVerified()) {
            throw new AlreadyVerifiedException();
        } else {
            this.emailStatus = 2;
        }
    }
}
