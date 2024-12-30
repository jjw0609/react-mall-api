package org.jjw.reactmallapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jjw.reactmallapi.dto.PageRequestDTO;
import org.jjw.reactmallapi.dto.PageResponseDTO;
import org.jjw.reactmallapi.dto.TodoDTO;
import org.jjw.reactmallapi.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {


    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable("tno") long tno) {

        return todoService.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {

        log.info("list............." + pageRequestDTO);

        return todoService.getList(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO dto) {

        log.info("todoDTO : " + dto);

        Long tno = todoService.register(dto);

        return Map.of("TNO", tno);
    }

}
