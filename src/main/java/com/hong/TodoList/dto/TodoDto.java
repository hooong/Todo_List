package com.hong.TodoList.dto;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.domain.Todo;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private Member member;
    private String title;
    private String subtitle;

    public Todo toEntity(){
        return Todo.builder()
                .id(id)
                .member(member)
                .title(title)
                .subtitle(subtitle)
                .build();
    }

    @Builder
    public TodoDto(Long id, Member member, String title, String subtitle) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.subtitle = subtitle;
    }
}
