package com.testing.todo.todo.service;

import com.testing.todo.todo.model.Todo;
import com.testing.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TodoServiceImp implements TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Override
    public List<Todo> getTodoByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todoRepository.save(new Todo(name,desc,targetDate,isDone));
    }

    @Override
    public void deleteTodo(long id) {
        Optional<Todo> todo=todoRepository.findById(id);
        if(todo.isPresent())
            todoRepository.delete(todo.get());
    }

    @Override
    public void saveTodo(Todo todo) {
    todoRepository.save(todo);
    }
}
