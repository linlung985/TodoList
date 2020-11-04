package com.sysage.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
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
        List<Todo> todos = new ArrayList<>();
        Todo todo = new Todo();
        todo.setTitle("Test");
        todo.setDescription("Nothing to do...");
        todo.setId(0);
        todo.setTimestamp(Instant.now());
        todos.add(todo);
        return todos;
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
