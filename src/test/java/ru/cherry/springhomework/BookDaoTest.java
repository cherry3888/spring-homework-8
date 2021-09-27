package ru.cherry.springhomework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import ru.cherry.springhomework.dao.BookRepository;
import ru.cherry.springhomework.domain.Author;
import ru.cherry.springhomework.domain.Book;
import ru.cherry.springhomework.domain.Genre;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class BookDaoTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MongoTemplate mt;


    @Test
    @DirtiesContext
    void getAllBooks() {
        List<Book> books = bookRepository.findAll();
        assertEquals(3, books.size());
    }

    @Test
    @DirtiesContext
    void insertBook() {
        Author author = mt.findById("1", Author.class);
        Genre genre = mt.findById("1", Genre.class);
        Book book = new Book("5", "Book-5", author, genre);
        bookRepository.save(book);
        Book book1 = mt.findById("5", Book.class);
        assertNotNull(book1);
        assertEquals(book.getTitle(), "Book-5");
    }

    @Test
    @DirtiesContext
    void updateBook() {
        Book book = mt.findById("1", Book.class);
        String newTitle = "Book-new";
        book.setTitle(newTitle);
        bookRepository.save(book);
        Book book1 = mt.findById("1", Book.class);
        assertEquals(newTitle, book1.getTitle());
    }

    @Test
    @DirtiesContext
    void deleteBook() {
        Book book = new Book("2", "Book-2");
        bookRepository.delete(book);
        Book book1 = mt.findById("2", Book.class);
        assertNull(book1);
    }

	@Test
	void getByTitle() {
		List<Book> books = bookRepository.findBooksByTitle("Book-3");
        assertEquals(books.size(), 1);
	}

}