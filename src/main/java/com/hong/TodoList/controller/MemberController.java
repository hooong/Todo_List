package com.hong.TodoList.controller;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.dto.MemberForm;
import com.hong.TodoList.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/signup")
    public String signupForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/members/signupForm";
    }

    @PostMapping("/members/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult result) {
        if (result.hasErrors()) {
            return "members/signupForm";
        }

        Member member = Member.builder()
                .userName(memberForm.getUserName())
                .password(memberForm.getPassword())
                .build();

        memberService.signUp(member);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/members/loginFrom";
    }

    @PostMapping("/members/login")
    public String login(@Valid MemberForm memberForm, BindingResult result) {
        if (result.hasErrors()) {
            return "members/loginForm";
        }

        Member member = Member.builder()
                .userName(memberForm.getUserName())
                .password(memberForm.getPassword())
                .build();

        memberService.login(member);
        return "redirect:/todolist";
    }
}
