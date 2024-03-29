package com.example.SpringDataJpa.repository;

import com.example.SpringDataJpa.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByUsername(String username);

    Page<Member> findByAge(int age , Pageable pageable);

}
