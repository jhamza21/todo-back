package com.example.controller;

import com.example.entities.Todo;
import com.example.entities.TodoStatusType;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService ts;


    @CrossOrigin
    @PostMapping("/addTodo")
    public Todo addTodo(@Valid @RequestBody Todo todo) {
        //CHECK IF TODO DELAYED
        LocalDate today=LocalDate.now();
        if(today.isAfter(todo.getEndDate())) todo.setStatus(TodoStatusType.DELAYED);
        return ts.saveTodo(todo);
    }

    @CrossOrigin
    @GetMapping("/todos")
    public List<Todo> findAllTodos() {
        return ts.findTodos();
    }

    @CrossOrigin
    @GetMapping("/todo/{id}")
    public Todo findTodoById(@PathVariable int id) {
        return ts.findTodoById(id);
    }

    @CrossOrigin
    @PutMapping("/update")
    public Todo UpdateTeam(@Valid @RequestBody Todo todo) {
        return ts.updateTodo(todo);
    }


    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        return ts.deleteTodo(id);
    }


}
