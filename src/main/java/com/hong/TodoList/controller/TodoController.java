package com.hong.TodoList.controller;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.dto.TodoDto;
import com.hong.TodoList.dto.TodoForm;
import com.hong.TodoList.service.MemberService;
import com.hong.TodoList.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;
    private MemberService memberService;

    @GetMapping("/todoCreate")
    public String createForm(Model model){
        model.addAttribute("todoform",new TodoForm());
        return "/todo/todoForm";
    }

    @PostMapping("/todoCreate")
    public String create(Authentication authentication, @Valid TodoForm todoForm, BindingResult result) {
        if (result.hasErrors()) {
            return "todo/todoForm";
        }

        Optional<Member> member = memberService.currentUser(authentication);
        todoService.createTodo(member.get(), todoForm);

        return "redirect:/";
    }


}
