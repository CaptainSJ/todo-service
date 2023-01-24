package dev.captainsj.todoservice.service;

import dev.captainsj.todoservice.model.Todo;
import dev.captainsj.todoservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonPlaceholderService {

    private static final Logger LOG = LoggerFactory.getLogger(JsonPlaceholderService.class);

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


        try {
            ResponseEntity<List<Todo>> exchange = restTemplate.exchange(
                    todoUrl + "todos",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Todo>>() {
                    }
            );

            if (exchange.getBody().size() > 0) {
                todoRepository.saveAll(exchange.getBody());

                pushTodos(exchange.getBody());
                return "Todos Fetched Successfully";
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
//            throw new RuntimeException(e.getMessage());
        }


        return "Failed to Fetch Todos";
    }


    public String pushTodos(List<Todo> todos) {


        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                dashboardUrl + "/todos",
                todos,
                String.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful())
            return "Pushed Successfully :)";

        return "Failed to Push Todos :(";
    }


}
