package com.hong.TodoList.domain;

import javafx.scene.effect.Blend;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
@Table(name="member")
public class MemberEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public MemberEntity(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
