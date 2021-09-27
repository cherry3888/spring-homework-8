package ru.cherry.springhomework.service;

import ru.cherry.springhomework.domain.Author;
import ru.cherry.springhomework.domain.Book;
import ru.cherry.springhomework.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Book addBook(String id, String title, Author author, Genre genre);

    List<Book> findBook(String title);

    Optional<Book> findBookById(String id);

    Book editBook(String id, String newTitle);

    boolean deleteBook(String id);
}
