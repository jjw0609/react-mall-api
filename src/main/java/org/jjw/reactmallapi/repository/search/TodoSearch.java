package org.jjw.reactmallapi.repository.search;

import org.jjw.reactmallapi.domain.Todo;
import org.jjw.reactmallapi.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);
}
