package com.springboot.todo_list.controllers;

import com.springboot.todo_list.domain.Author;
import com.springboot.todo_list.domain.Task;
import com.springboot.todo_list.exceptions.NotFoundException;
import com.springboot.todo_list.services.AuthorService;
import com.springboot.todo_list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/task")
public class MainController {
    private final TaskService taskService;
    private final AuthorService authorService;

    @Autowired
    public MainController(TaskService taskService, AuthorService authorService) {
        this.taskService = taskService;
        this.authorService = authorService;
    }

    @GetMapping(value = "/list")
    public Iterable<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @GetMapping(value = "/list/{id}")
    public Task getOne(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    //id - author_id
    @PostMapping(value = "/add/{id}")
    public Task createTask(@PathVariable Long id,
                           @RequestBody Task task) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            throw new NotFoundException();
        } else {
            task.setCreationDate(LocalDateTime.now());
            task.setAuthor(author);
            return taskService.saveTask(task);
        }
    }

    @PutMapping(value = "/update/{id}")
    public Task updateTask(@RequestBody Task task,
                           @PathVariable Long id) {
        Task taskFromDb = taskService.getTaskById(id);
        if (!task.getName().equals("")) {
            taskFromDb.setName(task.getName());
        }
        if (task.getStatus().equals("completed") || task.getStatus().equals("closed")) {
            taskFromDb.setStatus(task.getStatus());
            taskFromDb.setEndDate(LocalDateTime.now());
        }
        return taskService.saveTask(taskFromDb);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
