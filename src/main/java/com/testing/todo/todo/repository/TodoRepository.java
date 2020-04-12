package com.testing.todo.todo.repository;

import com.testing.todo.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByUserName(String user);
    Optional<Todo> findById(Long id);
}
