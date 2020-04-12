package com.testing.todo.todo.service;

import com.testing.todo.todo.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getTodoByUser(String user);

    Optional<Todo> getTodoById(Long id);

    void updateTodo(Todo todo);

    void addTodo(String name, String desc, Date targetDate, boolean isDone);

    void deleteTodo(long id);

    void saveTodo(Todo todo);
}
