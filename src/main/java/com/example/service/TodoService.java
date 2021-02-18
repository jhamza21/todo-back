package com.example.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.entities.Todo;
import com.example.entities.TodoStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository tr;

    public Todo saveTodo(Todo todo) {
            return tr.save(todo);
    }

    public List<Todo> findTodos() {
            return tr.findAll();
    }

    public Todo findTodoById(int id) {
            return tr.findById(id).orElse(null);
    }


    public String deleteTodo(int id) {
            tr.deleteById(id);
            return "Todo deleted : "+id;
    }

    public Todo updateTodo(Todo todo) {
        Todo exist=tr.findById(todo.getId()).orElse(null);
        exist.setTitle(todo.getTitle());
        exist.setDescription(todo.getDescription());
        exist.setStartDate(todo.getStartDate());
        exist.setEndDate(todo.getEndDate());
        exist.setStatus(todo.getStatus());
        return tr.save(exist);
    }



}
