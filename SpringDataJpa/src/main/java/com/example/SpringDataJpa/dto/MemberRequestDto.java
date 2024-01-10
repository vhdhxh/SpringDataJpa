package com.example.SpringDataJpa.dto;

import com.example.SpringDataJpa.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private int age;

    public Member toEntitiy(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .id(memberRequestDto.getId())
                .email(memberRequestDto.getEmail())
                .age(memberRequestDto.getAge())
                .password(memberRequestDto.getPassword())
                .username(memberRequestDto.getUsername())
                .build();
    }
}
