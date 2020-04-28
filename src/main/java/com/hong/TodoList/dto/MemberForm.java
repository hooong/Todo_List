package com.hong.TodoList.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "유저명을 입력해주세요.")
    private String userName;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

}
