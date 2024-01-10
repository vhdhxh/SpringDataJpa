package com.example.SpringDataJpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(of = {"id", "username", "age"})
@Builder
@AllArgsConstructor
public class Member {

    protected  Member() {

    }

    public Member(String username) {
        this.username = username;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private String username;
    private int age;



}
