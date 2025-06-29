package org.jjw.reactmallapi.service;


import lombok.extern.log4j.Log4j2;
import org.jjw.reactmallapi.domain.Todo;
import org.jjw.reactmallapi.dto.PageRequestDTO;
import org.jjw.reactmallapi.dto.PageResponseDTO;
import org.jjw.reactmallapi.dto.TodoDTO;
import org.jjw.reactmallapi.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Long register(TodoDTO dto) {

        Todo todo = dtoToEntity(dto);

        Todo result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modify(TodoDTO dto) {

        Optional<Todo> result = todoRepository.findById(dto.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(dto.getTitle());
        todo.changeContent(dto.getContent());
        todo.changeCompleted(dto.isCompleted());
        todo.changeDueDate(dto.getDueDate());

        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        //JPA
//        Page<Todo> result = todoRepository.search1(pageRequestDTO);
//
//        List<TodoDTO> dtoList = result.get().map(todo -> entityToDTO(todo)).collect(Collectors.toList());
//
//        PageResponseDTO<TodoDTO> responseDTO =
//                PageResponseDTO.<TodoDTO>withAll()
//                        .dtoList(dtoList)
//                        .pageRequestDTO(pageRequestDTO)
//                        .totalCount(result.getTotalElements())
//                        .build();
//
//        return responseDTO;
        return null;
    }

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }
}
