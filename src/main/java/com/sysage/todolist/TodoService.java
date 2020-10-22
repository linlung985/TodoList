package com.sysage.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Optional<Todo> get(int id) {
        return todoRepository.findById(id);
    }

    public List<Todo> list() {
        return todoRepository.findAll();
    }

    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    public void update(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }
}
