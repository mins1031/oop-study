package com.example.oopbasic;

import com.example.oopbasic.encapsulation.example1.member.MemberShip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String ownerName;
    private MemberShip memberShip;
    private LocalDate serviceDate;
    private LocalDate expDate;

}
