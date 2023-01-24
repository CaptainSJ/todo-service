package dev.captainsj.todoservice.controller;

import dev.captainsj.todoservice.service.JsonPlaceholderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private JsonPlaceholderService jsonPlaceholderService;

    public TodoController(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }


    @GetMapping("/fetch")
    public String fetchTodos() {
        String response = jsonPlaceholderService.getTodos();
        return response;
    }

//    @GetMapping("/getTodos/{$id}")

    @GetMapping("/push")
    public String pushTodos() {
        return null;
    }
}
