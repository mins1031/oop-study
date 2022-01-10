package com.example.oopbasic.encapsulation.example1.member.repository;

import com.example.oopbasic.encapsulation.example1.member.domain.Member;

public class MemberRepository {

    public Member findOne(String id) {
        return new Member(id);
    }
}
