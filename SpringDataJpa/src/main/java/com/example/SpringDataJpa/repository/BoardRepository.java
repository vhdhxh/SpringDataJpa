package com.example.SpringDataJpa.repository;

import com.example.SpringDataJpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

   List<Board> findAll();
   Board findAllByTitleAndContents(String title, String contents);
}
