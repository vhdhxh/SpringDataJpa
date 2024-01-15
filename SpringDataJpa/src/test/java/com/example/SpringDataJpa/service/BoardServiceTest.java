package com.example.SpringDataJpa.service;

import com.example.SpringDataJpa.dto.BoardWriteDto;
import com.example.SpringDataJpa.entity.Board;
import com.example.SpringDataJpa.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
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
class BoardServiceTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardService boardService;

 @DisplayName("게시글을 작성하고 id 를 반환한다")
 @Test
 void insertBoard() {
 //when
     BoardWriteDto boardWriteDto = BoardWriteDto.builder().title("제목").contents("내용").build();
 //given
Long id = boardService.writeBoard(boardWriteDto);
Board board = boardRepository.findAllByTitleAndContents("제목","내용");
 //then
     assertThat(board.getContents()).isEqualTo("내용");
     assertThat(board.getTitle()).isEqualTo("제목");
     assertThat(id).isEqualTo(1);
 }

 @DisplayName("게시글을 삭제한다.")
 @Test
 void deleteBoard() {
     //when
     BoardWriteDto boardWriteDto = BoardWriteDto.builder().title("제목").contents("내용").build();
     //given
     Long id = boardService.writeBoard(boardWriteDto);
     Board board = boardRepository.findAllByTitleAndContents("제목","내용");
     boardService.deleteBoard(id);
     Optional<Board> board1 = boardRepository.findById(id);
     //then

     assertThat(board1).isEmpty();

 }
}