package com.sysage.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id) {
        Optional<Todo> todoOptional = todoService.get(id);
        return todoOptional.orElseThrow();
    }

    @GetMapping
    public List<Todo> list() {
        return todoService.list();
    }

    @PostMapping
    public void create(Todo todo) {
        todoService.create(todo);
    }

    @PutMapping
    public void update(Todo todo) {
        todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        todoService.delete(id);
    }
}
