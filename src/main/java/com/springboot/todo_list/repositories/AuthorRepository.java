package com.springboot.todo_list.repositories;

import com.springboot.todo_list.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
