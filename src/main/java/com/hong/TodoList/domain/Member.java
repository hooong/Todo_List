package com.hong.TodoList.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userName;
    private String password;

    @Builder
    public Member(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
