package com.testing.todo.todo.controller;

import com.testing.todo.todo.model.Todo;
import com.testing.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
   private TodoService todoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }

    @RequestMapping(value = "/list-todos")
    public String showTodoList(ModelMap modelMap) {
        String name = getLoggedInUserName(modelMap);
        modelMap.put("todos", todoService.getTodoByUser(name));
        return "list-todos";
    }
    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @RequestMapping(value = "/add-naya", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }
    @RequestMapping(value = "/add-naya", method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo)
    {
        todo.setUserName(getLoggedInUserName(modelMap));
        todoService.saveTodo(todo);
        List<Todo> todoList=todoService.getTodoByUser(getLoggedInUserName(modelMap));
        modelMap.addAttribute("todos",todoList);
        return "list-todos";
    }
    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam long id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Todo todo = todoService.getTodoById(id).get();
        model.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo){
        todo.setUserName(getLoggedInUserName(model));
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

}
