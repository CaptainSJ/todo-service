package dev.captainsj.todoservice.repository;

import dev.captainsj.todoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
