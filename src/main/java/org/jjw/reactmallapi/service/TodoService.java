package org.jjw.reactmallapi.service;

import jakarta.transaction.Transactional;
import org.jjw.reactmallapi.domain.Todo;
import org.jjw.reactmallapi.dto.TodoDTO;

@Transactional
public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno);

    default TodoDTO entityToDTO(Todo todo) {

        return TodoDTO.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .content(todo.getContent())
                .completed(todo.isCompleted())
                .dueDate(todo.getDueDate())
                .build();
    }

    default Todo dtoToEntity(TodoDTO todoDTO) {

        return Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .completed(todoDTO.isCompleted())
                .dueDate(todoDTO.getDueDate())
                .build();
    }
}
