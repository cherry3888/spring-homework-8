package ru.cherry.springhomework.service;

import ru.cherry.springhomework.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author addAuthor(String id, String name);

    Optional<Author> getAuthorById(String id);

    Author getAuthor(String name);

    Author editAuthor(Author author);

    boolean deleteAuthor(String id);
}
