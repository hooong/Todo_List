package com.hong.TodoList.service;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.domain.Todo;
import com.hong.TodoList.dto.TodoDto;
import com.hong.TodoList.dto.TodoForm;
import com.hong.TodoList.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    // todo작성
    @Transactional
    public Long createTodo(Member member, TodoForm todoForm) {
        TodoDto todo = new TodoDto();
        todo.setMember(member);
        todo.setTitle(todoForm.getTitle());
        todo.setSubtitle(todoForm.getSubtitle());

        return todoRepository.save(todo.toEntity()).getId();
    }

    // todo삭제
    @Transactional
    public void delTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (!todo.isEmpty()) {
            todoRepository.delete(todo.get());
        }
    }

    // todo조회
}
