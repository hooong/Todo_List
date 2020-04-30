package com.hong.TodoList.controller;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.dto.MemberDto;
import com.hong.TodoList.dto.MemberForm;
import com.hong.TodoList.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

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

        MemberDto memberDto = new MemberDto();
        memberDto.setUserName(memberForm.getUserName());
        memberDto.setPassword(memberForm.getPassword());

        memberService.signUp(memberDto);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "/members/loginFrom";
    }

    @GetMapping("/members/login/result")
    public String loginSuccess() {
        return "/members/successLogin";
    }
}
