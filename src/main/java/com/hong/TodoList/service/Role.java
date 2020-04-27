package com.hong.TodoList.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;
}
