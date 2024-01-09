package com.example.SpringDataJpa.entity;

import com.example.SpringDataJpa.dto.BoardPagingDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
public class Board {
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;
    private String contents;
    private String title;
    private String writer;
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static BoardPagingDto toDto(Board entity) {
        return BoardPagingDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .writer(entity.getWriter())
                .build();
    }
    }


