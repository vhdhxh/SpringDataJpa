package com.example.SpringDataJpa.service;
import com.example.SpringDataJpa.dto.MemberDto;
import com.example.SpringDataJpa.entity.Member;
import com.example.SpringDataJpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void Register(MemberDto memberDto) {
      Member member = Member.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .username(memberDto.getUsername())
                .age(memberDto.getAge())
                .build();
        memberRepository.save(member);
    }
}
