package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.dto.BoardPagingDto;
import com.example.SpringDataJpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApi {
    private final BoardService boardService;

    //게시판 조회(페이징)
    @GetMapping("/Board")
    public ResponseEntity getBoardAll() {
       BoardPagingDto boardPagingDto = boardService.getBoardAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
