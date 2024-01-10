package com.example.SpringDataJpa.dto;

import com.example.SpringDataJpa.entity.Board;
import com.example.SpringDataJpa.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardWriteDto {
    private String title;
    private String contents;
    private Long memberId;
    private LocalDateTime time;
    private String writer;

    public Board toEntity(BoardWriteDto boardWriteDto) {
        return Board.builder()
                .title(boardWriteDto.getTitle())
                .contents(boardWriteDto.getContents())
                .member(Member.builder().id(boardWriteDto.getMemberId()).build())
                .build();
    }
}
