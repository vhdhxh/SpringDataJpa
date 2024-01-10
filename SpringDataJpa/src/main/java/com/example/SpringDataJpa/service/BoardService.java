package com.example.SpringDataJpa.service;

import com.example.SpringDataJpa.dto.BoardPagingDto;
import com.example.SpringDataJpa.dto.BoardWriteDto;
import com.example.SpringDataJpa.dto.MemberRequestDto;
import com.example.SpringDataJpa.entity.Board;
import com.example.SpringDataJpa.entity.Member;
import com.example.SpringDataJpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getBoardAll() {
        PageRequest pageRequest = PageRequest.of(0,10,Sort.by(Sort.Direction.ASC,"id"));
        Page<Board> board = boardRepository.findAll(pageRequest);
        board.map(b ->new BoardWriteDto());

       List<Board> boardList = board.getContent();
       return boardList;
    }

    public Long writeBoard(BoardWriteDto boardWriteDto , MemberRequestDto memberRequestDto) {
        Member member = memberRequestDto.toEntitiy(memberRequestDto);
        Board board = Board.builder()
                .title(boardWriteDto.getTitle())
                .writer(member.getUsername())
                .contents(boardWriteDto.getContents())
                .member(member)
                .build();
        return boardRepository.save(board).getId();
    }

}
