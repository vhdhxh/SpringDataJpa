package com.example.SpringDataJpa.entity;

import com.example.SpringDataJpa.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class BoardTest {
    @Autowired
    BoardRepository boardRepository;
    @Test
    void 보드엔티티테스트() {
        Board board = Board.builder().title("제목").contents("내용").build();
        boardRepository.save(board);
        boardRepository.findAll();


    }

}