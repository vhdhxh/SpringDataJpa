package com.example.SpringDataJpa.repository;

import com.example.SpringDataJpa.entity.Board;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @DisplayName("")
    @Test
    void test() {
    //when
    Board board = Board.builder().title("제목").contents("내용").build();
    //given
    boardRepository.save(board);
    Board board1 = boardRepository.findAllByTitleAndContents("제목","내용");
    //then
    assertThat(board1.getTitle()).isEqualTo("제목");
    assertThat(board1.getContents()).isEqualTo("내용");
    }

}