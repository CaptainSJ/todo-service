package dev.captainsj.todoservice.service;

import dev.captainsj.todoservice.model.Todo;
import dev.captainsj.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonPlaceholderService {

    @Value("${todo.api.url}")
    private String todoUrl;

    @Value("${dashboard.api.url}")
    private String dashboardUrl;

    private RestTemplate restTemplate;

    private TodoRepository todoRepository;

    public JsonPlaceholderService(RestTemplate restTemplate, TodoRepository todoRepository) {
        this.restTemplate = restTemplate;
        this.todoRepository = todoRepository;
    }

    public String getTodos() {

        ResponseEntity<List<Todo>> exchange = restTemplate.exchange(
                todoUrl + "todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {
                }
        );

        if(exchange.getBody().size() > 0) {
            todoRepository.saveAll(exchange.getBody());
            return "Todos Fetched Successfully";
        }

        return "Failed to Fetch Todos";
    }


    public String pushTodos() {
        return null;
    }


}
