package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.dto.MemberDto;
import com.example.SpringDataJpa.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class MemberApiTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void testRegister() throws Exception {
        MemberDto memberDto = MemberDto.builder().age(1).build();

        // memberDto 필드를 적절하게 설정하세요

        ObjectMapper objectMapper = new ObjectMapper();
        String memberDtoJson = objectMapper.writeValueAsString(memberDto);

        Mockito.doNothing().when(memberService).Register(Mockito.any(MemberDto.class));

        mockMvc.perform(post("/Register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(memberDtoJson))
                .andExpect(status().isOk());

        Mockito.verify(memberService, Mockito.times(1)).Register(Mockito.any(MemberDto.class));
    }
}