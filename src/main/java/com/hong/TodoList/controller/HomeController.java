package com.hong.TodoList.controller;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.domain.Todo;
import com.hong.TodoList.repository.MemberRepository;
import com.hong.TodoList.repository.TodoRepository;
import com.hong.TodoList.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {
    private MemberService memberService;
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        Optional<Member> userEntitywrapper = memberService.currentUser(authentication);

        if (!userEntitywrapper.isEmpty()) {
            Member userEntity = userEntitywrapper.get();

//            List<Todo> todos = todoRepository.findAllByid(userEntity.getId());

            model.addAttribute("id", userEntity.getId());
        }

        return "/home/index";
    }

    @GetMapping("/todolist")
    public String home() {
        return "/todolist";
    }
}
