package com.example.SpringDataJpa.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class BoardPagingDto {
    private Long id;
    private String title;
    private String writer;
    private LocalDateTime time;
    private String contents;

}
