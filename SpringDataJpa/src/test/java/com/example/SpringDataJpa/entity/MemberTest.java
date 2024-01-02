package com.example.SpringDataJpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {
    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity() {
        Team teamA  = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member ("member1", 10 ,teamA);
        Member member2 = new Member ("member2", 20 ,teamA);
        Member member3 = new Member ("member3", 30 ,teamB);
        Member member4 = new Member ("member4", 40 ,teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();
    }

}