package com.hong.TodoList.repository;

import com.hong.TodoList.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 해당 회원의 todo 불러오기
    List<Todo> findAllByid(Long id);
}
