package com.hong.TodoList.dto;

import com.hong.TodoList.domain.Member;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String userName;
    private String password;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
