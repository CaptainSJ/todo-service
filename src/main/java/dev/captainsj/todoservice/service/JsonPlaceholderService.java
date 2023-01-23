package dev.captainsj.todoservice.service;

import dev.captainsj.todoservice.model.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonPlaceholderService {

    @Value("${todo.api.url}")
    private String url;

    public String getTodos() {

        return null;
    }


}
