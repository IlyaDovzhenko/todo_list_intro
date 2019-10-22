package com.springboot.todo_list.services;

import com.springboot.todo_list.domain.Author;

public interface AuthorService {
    Iterable<Author> listAllAuthors();

    Author getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);
}
