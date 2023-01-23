package dev.captainsj.todoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    @GetMapping("/fetch")
    public String fetchTodos() {
        return null;
    }

    @GetMapping("/push")
    public String pushTodos() {

        return null;
    }
}
