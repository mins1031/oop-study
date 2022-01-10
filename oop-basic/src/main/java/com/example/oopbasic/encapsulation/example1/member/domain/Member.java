package com.example.oopbasic.encapsulation.example1.member.domain;

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

    public boolean isEmailStatusVerified(int status) {
        return this.emailStatus != status;
    }

    public boolean isPasswordValid(PasswordEncoder passwordEncoder, String inputPw) {
//        passwordEncoder.
        return true;
    }
}
