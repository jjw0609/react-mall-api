package org.jjw.reactmallapi.repository;

import org.jjw.reactmallapi.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
