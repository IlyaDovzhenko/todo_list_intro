package com.springboot.todo_list.repositories;

import com.springboot.todo_list.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
