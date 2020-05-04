package com.hong.TodoList.controller;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.repository.MemberRepository;
import com.hong.TodoList.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {
    private MemberService memberService;
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Optional<Member> userEntitywrapper = memberRepository.findByuserName(userDetails.getUsername());

        if (!userEntitywrapper.isEmpty()) {
            Member userEntity = userEntitywrapper.get();
            model.addAttribute("id", userEntity.getId());
        }

        return "/home/index";
    }

    @GetMapping("/todolist")
    public String home() {
        return "/todolist";
    }
}
