package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.dto.MemberDto;
import com.example.SpringDataJpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApi {
   private final MemberService memberService;


   //회원가입
   @PostMapping("/Register")
   public ResponseEntity Register(MemberDto memberDto){
       memberService.Register(memberDto);
       return ResponseEntity.status(HttpStatus.OK).body(null);
   }


}
