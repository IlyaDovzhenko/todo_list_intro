package com.springboot.todo_list.services;

import com.springboot.todo_list.domain.Task;

public interface TaskService {
    Iterable<Task> listAllTasks();

    Task getTaskById(Long id);

    Task saveTask(Task task);

    void deleteTask(Long id);
}
