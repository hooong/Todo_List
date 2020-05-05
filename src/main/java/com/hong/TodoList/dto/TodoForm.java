package com.hong.TodoList.dto;

import com.hong.TodoList.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
public class TodoForm {
    @NotEmpty(message = "할일을 입력해주세요!")
    private String title;
    private String subtitle;
}
