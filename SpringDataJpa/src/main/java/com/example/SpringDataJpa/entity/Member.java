package com.example.SpringDataJpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(of = {"id", "username", "age"})
public class Member {

    protected  Member() {

    }

    public Member(String username) {
        this.username = username;
    }

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username, int i, Team team) {
        this.username = username;
        this.age =age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam (Team team) {
        this.team = team;
        team.getMembers().add(this);

    }

}
