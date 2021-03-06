package com.hong.TodoList.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
public class Todo {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")     // FK
    private Member member;

    private String title;
    private String subtitle;

    @Builder
    public Todo(Long id, Member member, String title, String subtitle) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.subtitle = subtitle;
    }
}
