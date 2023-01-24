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

    @GetMapping("/is-live")
    public String isLive() {
        return "Yes Its Live :)";
    }


    @GetMapping("/fetch")
    public String fetchTodos() {
        String response = jsonPlaceholderService.getTodos();
        return response;
    }

//    @GetMapping("/getTodos/{$id}")

//    @GetMapping("/push")
//    public String pushTodos() {
//        String response = jsonPlaceholderService.pushTodos();
//        return response;
//    }
}
