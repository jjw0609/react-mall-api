package org.jjw.reactmallapi.service;


import lombok.extern.log4j.Log4j2;
import org.jjw.reactmallapi.domain.Todo;
import org.jjw.reactmallapi.dto.TodoDTO;
import org.jjw.reactmallapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }
}
