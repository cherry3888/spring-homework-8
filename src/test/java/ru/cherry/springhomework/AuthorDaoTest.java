package ru.cherry.springhomework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import ru.cherry.springhomework.dao.AuthorRepository;
import ru.cherry.springhomework.domain.Author;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class AuthorDaoTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private MongoTemplate mt;

    @Test
    void getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        assertEquals(3, authors.size());
    }

    @Test
    @DirtiesContext
    void insertAuthor() {
        Author author = new Author("4", "Author-4");
        authorRepository.save(author);
        Author author1 = mt.findById("4", Author.class);
        assertNotNull(author1);
    }

    @Test
    @DirtiesContext
    void updateAuthor() {
        Author author = mt.findById("3", Author.class);
        author.setName("Author-123");
        authorRepository.save(author);
        Author author1 = mt.findById("3", Author.class);
        assertNotNull(author1);
        assertEquals(author1.getName(), author.getName());
    }

	@Test
	@DirtiesContext
	void deleteAuthor() {
		Author author = mt.findById("1", Author.class);
		authorRepository.delete(author);
        Author author1 = mt.findById("1", Author.class);
		assertNull(author1);
	}

	@Test
	@DirtiesContext
	void getByName() {
		Author author = authorRepository.findAuthorByName("Author-1");
		assertNotNull(author);
	}

}