package com.hong.TodoList.service;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.domain.Todo;
import com.hong.TodoList.dto.TodoForm;
import com.hong.TodoList.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    // todo작성
    public void createTodo(Member member, TodoForm todoForm) {
        todoRepository.save(Todo.builder()
                                .member(member)
                                .title(todoForm.getTitle())
                                .subtitle(todoForm.getSubtitle())
                                .build());
    }

    // todo삭제

    // todo조회
}
