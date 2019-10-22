package com.springboot.todo_list.controllers;

import com.springboot.todo_list.domain.Author;
import com.springboot.todo_list.services.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = {"/list"})
    public Iterable<Author> getAllAuthors() {
        return authorService.listAllAuthors();
    }

    @GetMapping(value = {"/list/{id}"})
    public Author getOne(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping(value = {"/add"})
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping(value = {"/update/{id}"})
    public Author updateAuthor(@PathVariable Long id,
                               @RequestBody Author author) {
        Author authorFromDb = authorService.getAuthorById(id);
        BeanUtils.copyProperties(author, authorFromDb, "id");
        return authorService.saveAuthor(authorFromDb);
    }

    @DeleteMapping(value = {"/delete/{id}"})
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
