package com.example.SpringDataJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberDto {
    private String email;
    private String password;
    private String username;
    private int age;
}
