package com.example.SpringDataJpa.service;

import com.example.SpringDataJpa.dto.BoardPagingDto;
import com.example.SpringDataJpa.entity.Board;
import com.example.SpringDataJpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardPagingDto getBoardAll() {
        PageRequest pageRequest = PageRequest.of(0,10,Sort.by(Sort.Direction.ASC,"id"));
        Page<BoardPagingDto> boardPagingDto = boardRepository.findAll(pageRequest);
       Page<BoardPagingDto> boardPagingDto =
       return boardPagingDto;
    }

}
