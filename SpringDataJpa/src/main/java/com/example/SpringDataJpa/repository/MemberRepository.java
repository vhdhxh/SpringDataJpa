package com.example.SpringDataJpa.repository;

import com.example.SpringDataJpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
