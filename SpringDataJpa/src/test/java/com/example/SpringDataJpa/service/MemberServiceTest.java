package com.example.SpringDataJpa.service;

import com.example.SpringDataJpa.entity.Member;
import com.example.SpringDataJpa.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void 회원가입() {

        //when
        Member member = Member.builder()
                .email("vhdhxh@naver.com")
                .password("1234")
                .username("test")
                .age(14)
                .build();

        //given
       Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId()).get();
        assertThat(findMember.getEmail()).isEqualTo("vhdhxh@naver.com");
        System.out.println(findMember);


    }

}