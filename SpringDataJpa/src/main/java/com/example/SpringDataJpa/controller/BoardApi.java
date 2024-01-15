package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.dto.BoardPagingDto;
import com.example.SpringDataJpa.dto.BoardWriteDto;
import com.example.SpringDataJpa.dto.MemberRequestDto;
import com.example.SpringDataJpa.entity.Board;
import com.example.SpringDataJpa.repository.BoardRepository;
import com.example.SpringDataJpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApi {
    private final BoardService boardService;

    //게시판 조회(페이징)
    @GetMapping("/Board")
    public ResponseEntity getBoardAll() {
       List<Board> boardList = boardService.getBoardAll();
        System.out.println("sus");
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    //게시판 쓰기
    @PostMapping("/Board")
    public ResponseEntity writeBoard(@RequestBody BoardWriteDto boardWriteDto) {
        Long boardId =boardService.writeBoard(boardWriteDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardId);
    }

}
