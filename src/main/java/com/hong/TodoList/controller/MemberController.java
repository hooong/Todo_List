package com.hong.TodoList.controller;

import com.hong.TodoList.domain.MemberEntity;
import com.hong.TodoList.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.channels.MembershipKey;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/todolist")
    public String todolist() {
        return "/todolist";
    }

    @GetMapping("/user/login")
    public String loginpage() {
        return "/user/login";
    }

    @PostMapping("/user/login")
    public String login() {

    }
}
