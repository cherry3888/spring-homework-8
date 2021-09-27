package ru.cherry.springhomework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cherry.springhomework.dao.AuthorRepository;
import ru.cherry.springhomework.dao.BookRepository;
import ru.cherry.springhomework.dao.GenreRepository;
import ru.cherry.springhomework.domain.Author;
import ru.cherry.springhomework.domain.Book;
import ru.cherry.springhomework.domain.Genre;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public Book addBook(String id, String title, Author author, Genre genre) {
        Book book = bookRepository.findBookByTitleAndAuthorIdAndGenreId(title, author.getId(), genre.getId());
        if (null == book) {
            return bookRepository.save(new Book(id, title, author, genre));
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findBook(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }

    @Transactional
    @Override
    public Book editBook(String id, String newTitle) {
        Optional<Book> bookO = bookRepository.findById((id));
        if (bookO.isPresent()) {
            Book book = bookO.get();
            book.setTitle(newTitle);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean deleteBook(String id) {
        Optional<Book> bookO = bookRepository.findById(id);
        if (bookO.isPresent()) {
            bookRepository.delete(bookO.get());
            return true;
        } else {
            return false;
        }
    }
}
